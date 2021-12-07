package co.com.appgate.prueba.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.com.appgate.prueba.domain.LoginValidation;
import co.com.appgate.prueba.dto.UserDTO;

@Controller
public class FormController {

	@Autowired
	private LoginValidation loginValidation;

	@GetMapping("/form")
	public String form(Model model) {
		UserDTO userDto = new UserDTO();
		model.addAttribute("title", "User Login :: AppGate - Tech Test");
		model.addAttribute("header3", "User Credentials");
		model.addAttribute("userDto", userDto);
		return "form";
	}

	@PostMapping("/form")
	public String process(@Valid UserDTO userDto, BindingResult bindingResult, Model model) {
		Map<String, String> errorsMap = new HashMap<String,String>();
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "User Login :: AppGate - Tech Test");
			model.addAttribute("header3", "User Credentials");
			bindingResult.getFieldErrors().forEach(list ->{
				errorsMap.put(list.getField(), list.getField().concat(", ").concat(list.getDefaultMessage()));
			});
			model.addAttribute("error",errorsMap);
			model.addAttribute("userdto", userDto);
			return "form";
		} 
		
		if (!loginValidation.isValidLogin(userDto)) {
			model.addAttribute("title", "User Login :: AppGate - Tech Test");
			model.addAttribute("header3", "User Credentials");
			errorsMap.put("Login", "User or Password invalid, please try again");
			model.addAttribute("error",errorsMap);
			model.addAttribute("userDto", userDto);
			return "form";
		}
		
		
		return "operations";
	}

}
