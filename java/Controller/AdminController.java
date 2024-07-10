package Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import Service.AdminService;
import entity.Admin;

@Controller
@RequestMapping("/admin/users")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping
    public String getAllAdmins(Model model) {
        model.addAttribute("admins", adminService.getAllAdmins());
        return "admin/admin-list";
    }

    @GetMapping("/{id}")
    public String getAdminById(@PathVariable Long id, Model model) {
        Admin admin = adminService.getAdminById(id);
        if (admin != null) {
            model.addAttribute("admin", admin);
            return "admin/admin-detail";
        } else {
            return "404";
        }
    }

    @GetMapping("/new")
    public String newAdminForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin/admin-form";
    }

    @PostMapping
    public String saveAdmin(@ModelAttribute Admin admin) {
        adminService.saveAdmin(admin);
        return "redirect:/admin/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return "redirect:/admin/users";
    }
}
