package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@ModelAttribute
	public UpdateEmployeeForm setUpUpdateEmployeeForm() {
		return new UpdateEmployeeForm();
	}

	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Employee> employeeList = service.showList();
		model.addAttribute("employeeList", employeeList);
		return "employee/list";
	}

	@RequestMapping("/showDetail")
	public String showDeatil(String id, Model model) {
		Employee employee = service.showDetail(Integer.parseInt(id));
		model.addAttribute("employee", employee);
		return "employee/detail";
	}

	@RequestMapping("/update")
	public String update(UpdateEmployeeForm form) {
		Employee employee = service.showDetail(form.getIntId());
		BeanUtils.copyProperties(form, employee);
		employee.setDependentsCount(form.getIntDependentsCount());
		employee.setSalary(form.getIntSaraly());
		employee.setHireDate(form.getDateHireDate());

		service.update(employee);
		return "redirect:/employee/showList";
	}
}
