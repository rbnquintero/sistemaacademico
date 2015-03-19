package com.rbnquintero.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rbnquintero.system.util.ConstantesWeb;

@Controller
public class MainController {
	private static final Logger _log = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		return "maestro/home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest request, @RequestParam(value = "logout", required = false) String logout) {

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}

		return "login/login";
	}

	@RequestMapping(value = "/login/{exceptionMotive}", method = RequestMethod.POST)
	public String loginPost(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes,
			@PathVariable("exceptionMotive") String exceptionMotive) {
		String error = null;

		if (exceptionMotive.equals(ConstantesWeb.SS_USUARIO_EXISTE_LDAP)) {
			error = "Tu usuario o contraseña son incorrectos";
		} else if (exceptionMotive.equals(ConstantesWeb.SS_INTENTOS_LOGIN)) {
			error = "Has superado el máximo de intentos permitidos";
		} else if (exceptionMotive.equals(ConstantesWeb.SS_OBTENER_USUARIO_PORTAL)) {
			error = "No se pudo obtener tu usario, contacta soporte";
		} else if (exceptionMotive.equals(ConstantesWeb.SS_AUTENTICA_LDAP)) {
			error = "Tu usuario o contraseña son incorrectos";
		} else if (exceptionMotive.equals(ConstantesWeb.SS_USUARIO_NO_CONFIRMADO)) {
			error = "Cuenta sin confirmar";
		} else if (exceptionMotive.equals(ConstantesWeb.SS_CUENTA_CARGOS)) {
			error = "Tu cuenta tiene cargos";
		} else if (exceptionMotive.equals(ConstantesWeb.SS_CREDENCIALES_INVALIDAS)) {
			error = "Tu usuario o contraseña son incorrectos";
		} else if (exceptionMotive.equals(ConstantesWeb.SS_AUTENTICACION)) {
			error = "Tu usuario o contraseña son incorrectos";
		} else if (exceptionMotive.equals(ConstantesWeb.SS_ERROR_INTERNO)) {
			error = "Ocurrió un error interno, intenta mas tarde";
		} else {
			error = "Ocurrió un error inesperado";
		}
		_log.error(exceptionMotive);
		redirectAttributes.addFlashAttribute("error", error);
		return "redirect:/login";
	}
}
