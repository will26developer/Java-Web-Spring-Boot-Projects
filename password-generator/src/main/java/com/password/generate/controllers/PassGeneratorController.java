package com.password.generate.controllers;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.password.generate.models.forms.PasswordForm;


@Controller
@RequestMapping("/")
public class PassGeneratorController {

	@GetMapping
	public String redirectHome(Model model) {
		return "redirect:/lightmode";
	}
	
	@GetMapping("/lightmode")
	public String getIndexPageLight(Model model) {
		int[] selectMenu={4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,
		                  22,23,24,25,25,27,28,29,30};
		model.addAttribute("passwordForm",new PasswordForm()); 
		model.addAttribute("selectMenu", selectMenu);
		return "index_password_generator_light";
	}

	@GetMapping("/darkmode")
	public String getIndexPageDark(Model model) {
		int[] selectMenu={4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
		                  21,22,23,24,25,26,27,28,29,30};
		model.addAttribute("passwordForm", new PasswordForm());
		model.addAttribute("selectMenu", selectMenu);
		return "index_password_generator_dark";
	}

	@PostMapping("/generateLight")
	public String getPasswordFormLight(@ModelAttribute PasswordForm passwordForm,RedirectAttributes redirectAttributes,Model model) { 
		String password=generatePassword(passwordForm); 
		redirectAttributes.addFlashAttribute("password", password);
		return "redirect:/lightmode";
	}

	@PostMapping("/generateDark")
	public String getPasswordFormDark(@ModelAttribute PasswordForm passwordForm,RedirectAttributes redirectAttributes,Model model) { 
		String password=generatePassword(passwordForm); 
		redirectAttributes.addFlashAttribute("password", password);
		return "redirect:/darkmode";
	}
	

	private String generatePassword(PasswordForm form) { 
		Random random=new Random();
		StringBuilder chain=new StringBuilder();
		StringBuilder password=new StringBuilder();
		String characters="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		String numbers="0123456789";
		String punctuations="~$€%/|!@?¿'()¬&{}:,.*[]"; 
		if (form.getLetters().equals(true)) chain.append(characters);
		if (form.getDigits().equals(true)) chain.append(numbers);
		if (form.getSymbols().equals(true)) chain.append(punctuations); 
		if (form.getLetters().equals(false) && form.getDigits().equals(false) && form.getSymbols().equals(false)) {
			chain.append(characters);
			chain.append(numbers);
			chain.append(punctuations);
		}
		for (int i=0;i<form.getPassLenght();i++) {
			int num=random.nextInt(chain.length());
			password.append(chain.charAt(num));
		}
		return password.toString();
	}
}
