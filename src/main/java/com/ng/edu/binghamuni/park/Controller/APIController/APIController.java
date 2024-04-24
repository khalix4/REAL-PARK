package com.ng.edu.binghamuni.park.Controller.APIController;

import com.ng.edu.binghamuni.park.Domain.CustomerInformation;
import com.ng.edu.binghamuni.park.Repository.FormRepository;
import com.ng.edu.binghamuni.park.Services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.BeanUtils;

@Controller
public class APIController {

    @Autowired

        FormRepository formRepository;
    @Autowired
        FormService formService;

        @GetMapping("/")
        public String homepage(Model model){
            model.addAttribute("customers", formService.getAllCustomer());
            return "index";
        }

        @GetMapping("/showNewForm")
        public String showNewForm(Model model){
            CustomerInformation customer = new CustomerInformation();
            model.addAttribute("customer",customer);

            return "FormContent";
        }
@GetMapping("/showDashboard")
        public String showDashboard(Model model){
            long numberOfCustomers = formService.getTotalCustomers();
            long numberOfWebAd=formService.getTotalWebAddSourceCount();
            long numberOfWordOfMouthAd=formService.getTotalWordOfMouthSourceCount();
            long numberOfNewspaperAd=formService.getTotalNewspaperSourceCount();
        model.addAttribute("numberOfCustomers", numberOfCustomers);
    model.addAttribute("numberOfWebAd", numberOfWebAd);
    model.addAttribute("numberOfWordOfMouthAd", numberOfWordOfMouthAd);
    model.addAttribute("numberOfNewspaperAd", numberOfNewspaperAd);

    String highestAdSource = formService.calculateHighestAdSource();
    double highestAdPercentage = formService.calculateHighestAdPercentage();

    // Set attributes in the model
    model.addAttribute("highestAdSource", highestAdSource);
    model.addAttribute("highestAdPercentage", highestAdPercentage);
                return "Dashboard";
        }

        @GetMapping("/showAdminForm")
        public String showAdminForm(){
                return "adminForm";
        }
    @GetMapping("/showBillOfSales")
        public String showBillOfSales(){
                return "BillOfSales";
        }

    @GetMapping("/showFormTable")
    public String showFormTable(Model model){
        model.addAttribute("customers", formService.getAllCustomer());

        return "FormTable";
    }

        @PostMapping ("/saveForm")
        public String saveForm(@ModelAttribute("customer") CustomerInformation customerInformation){
            formService.saveCustomer(customerInformation);
            return "redirect:/showBillOfSales";
        }


        @GetMapping("/showEditFormTable/{id}")
        public String showEditFormTable(@PathVariable("id") Long id, Model model) {
            try {
                CustomerInformation customerInformation = formService.getCustomerbyId(id);
                model.addAttribute("customer", customerInformation);
                model.addAttribute("pageTitle", "Edit Customer Id:" + id);
                return "EditFormTable";
            } catch (Exception e) {
                return "redirect:/";
            }
        }
        @PostMapping("/updateFormData")
        public String updateFormData(@ModelAttribute("customer") CustomerInformation newCustomer, RedirectAttributes redirectAttributes) {
            try {
                // Get the existing drink from the database by its ID
                CustomerInformation oldCustomer = formService.getCustomerbyId(newCustomer.getId());

                // Copy properties from updatedDrink to existingDrink
                BeanUtils.copyProperties(newCustomer, oldCustomer, "id", "created_at", "updated_at", "formContent");

                // Save the updated drink
                formService.saveCustomer(oldCustomer);

                redirectAttributes.addFlashAttribute("message", "Customer Data updated successfully");
                return "redirect:/showFormTable";
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("message", e.getMessage());
                return "redirect:/";
            }
        }
        @GetMapping("deleteFormData/{id}")
        public String deleteFormData(@PathVariable("id") long id, RedirectAttributes redirectAttributes){
            formService.deleteCustomer(id);
            redirectAttributes.addFlashAttribute("message", "Customer Data Deleted successfully");

            return "redirect:/showFormTable";
        }
    }
