package net.softsociety.testboot.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@ResponseBody
@Slf4j
public class CompilerController {

	@PostMapping("compile")
	public String compileResult(String language, String code) {
		log.debug("language : {}, code : {}", language, code);

		// 유저 이름? 아이디?로 파일이름 생성하기
		int userid = 1234;
		// 자바에선 동작하지만 c에선 동작하지 않는 패스라 일단 제거
		// String path = "src/main/resources/static/codes/";
		String path = "";
		// 현재 패스 찾는거 알 수 있는 방법이 있나?
		String fullpath = "/user/Documents/ProLingo-teamProject/" + path;
		
		if (language.equals("java")) {
			String filename = userid + "_Javacode.java";
			// code 에서 클래스 이름을 꺼내오게 하는게 더 좋긴 한데 일단 이대로
			String classname = "Main";

			try {
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + filename));
				byte[] by = code.getBytes();
				bos.write(by);
				bos.close();
				// 필요 없나?
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				// 한글 인코딩 문제 해결
				// https://proni.tistory.com/82
				Runtime.getRuntime().exec("cmd /c javac -encoding UTF-8 " + fullpath + filename).waitFor();

			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			String result = execCmd("java -cp " + fullpath + " " + classname, "java");
			//String result = execCmd("cd", "java");
			result = "javac -encoding UTF-8 " + fullpath + filename;
			log.debug("실행 결과 : {}", result);

			return result;
		} else if (language.equals("c")) {
			String filename = userid + "_Ccode.c";
			String exename = "main";

			try {
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + filename));
				byte[] by = code.getBytes();
				bos.write(by);
				bos.close();
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				// 내가 원하는 경로에 넣는 방법을 모르겠음, 그냥 디폴트(프로젝트 최상위) 경로로만 만들어짐
				Runtime.getRuntime().exec("cmd /c gcc -o " + exename + " " + fullpath + filename).waitFor();
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}

			String result = execCmd(exename, "c");

			log.debug("실행 결과 : {}", result);

			return result;
		}

		return "false";
	}

	public String execCmd(String cmd, String language) {
		try {
			Process process = Runtime.getRuntime().exec("cmd /c " + cmd);
			// 한글 읽는거 깨지는거 해결
			// https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=slayra&logNo=221215991017
			String charset = "";
			switch (language) {
			case "java":
				charset = "MS949";
				break;
			case "c":
				charset = "UTF-8";
				break;
			default:
				charset = "MS949";
				break;
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), charset));

			String line = null;
			StringBuffer sb = new StringBuffer();
			// sb.append(cmd);
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
