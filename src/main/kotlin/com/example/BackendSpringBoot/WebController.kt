package com.example.BackendSpringBoot

import com.example.BackendSpringBoot.dto.LoginDTO
import com.example.BackendSpringBoot.dto.RegisterDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class WebController {

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("registerDTO", RegisterDTO())
        model.addAttribute("loginDTO", LoginDTO())
        return "index"
    }

    @GetMapping("/register.html")
    fun register(model: Model): String {
        model.addAttribute("registerDTO", RegisterDTO())
        return "register"
    }

    @GetMapping("/login.html")
    fun login(model: Model): String {
        model.addAttribute("loginDTO", LoginDTO())
        return "login"
    }
    @GetMapping("/weather.html")
    fun weather(model: Model): String {
        return "weather"
    }
}