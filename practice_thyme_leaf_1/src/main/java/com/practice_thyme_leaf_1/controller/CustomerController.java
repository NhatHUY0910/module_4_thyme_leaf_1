package com.practice_thyme_leaf_1.controller;

import com.practice_thyme_leaf_1.model.Customer;
import com.practice_thyme_leaf_1.servcie.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute("customerList", customerList);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Customer customer) {
        customer.setId((int)(Math.random() * 10000));
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        customerService.updateCustomer(customer.getId(), customer);
        return "redirect:/customers";
    }

    @GetMapping("/confirm-delete/{id}")
    public String confirmDelete(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.deleteCustomer(customer.getId());
        redirectAttributes.addFlashAttribute("message", "Customer deleted successfully");
        return "redirect:/customers";
    }

    @GetMapping("/view-detail/{id}")
    public String viewDetail(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "/view_detail";
    }
}
