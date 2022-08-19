package com.varxyz.eka.consulting.controller;


//@Controller("consultingController")
public class ConsultingController {

//	@Autowired
//	private ConsultingServiceImp consultingService;		
//	@Autowired
//	private AcademyListServiceImp academyService;

//	@GetMapping("eka_manager/consulting_edit")
//	public String ConsultingEdit(Model model) {
//		Academy academy = academyService.findAcademyByRegistationNum("11-11-11");
//		List<Consulting> registConsultingList = consultingService.findAllAcademyRegistConsulting(academy);
//		model.addAttribute("registConsultingList",registConsultingList);
//		return "eka_manager/consulting_edit";
//	}
//	
//
//	@GetMapping("eka_manager/consulting_unuser")
//	public String consultingUnuser(Model model) {
//		Academy academy = academyService.findAcademyByRegistationNum("11-11-11");
//		List<Consulting> applyConsultingList = consultingService.findAllAcademyApplyConsulting(academy);
//		model.addAttribute("applyConsultingList",applyConsultingList);
//		return "eka_manager/consulting_unuser";
//	}
//	
//	@GetMapping("eka_manager/consulting_eka")
//	public String consulting(Model model) {
//		Academy academy = academyService.findAcademyByRegistationNum("11-11-11");
//		List<Consulting> applyConsultingList = consultingService.findAllAcademyApplyConsulting(academy);
//
//		model.addAttribute("applyConsultingList",applyConsultingList);
//		return "eka_manager/consulting_eka";
//	}
//	
//	@PostMapping("eka_manager/applyconsulting_select")
//	public String applyConsultingSelect(Model model, @RequestParam String name,
//			@RequestParam String applyDate, @RequestParam String consultType) throws ParseException {		
//		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
//		Date to = fm.parse(applyDate);
//		System.out.println(to);
//		
//		Academy academy = academyService.findAcademyByRegistationNum("11-11-11");
//		Consulting applyConsult = consultingService.findAcademyApplyConsultingByRegDateAndName(academy, to , name);		
//		
//		List<Consulting> applyConsultingList = consultingService.findAllAcademyApplyConsulting(academy);
//		model.addAttribute("applyConsult",applyConsult);
//		model.addAttribute("applyConsultingList",applyConsultingList);
//		return "eka_manager/consulting_eka";		
//	}
//	
//	@PostMapping("eka_manager/registconsulting_select")
//	public String registConsultingSelect(Model model, @RequestParam String name,
//			@RequestParam String applyDate, @RequestParam String consultType) throws ParseException {		
//		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
//		Date to = fm.parse(applyDate);
//		System.out.println(to);
//		
//		Academy academy = academyService.findAcademyByRegistationNum("11-11-11");
//		Consulting registConsult = consultingService.findAcademyRegistConsultingByRegDateAndName(academy, to , name);		
//		
//		List<Consulting> registConsultingList = consultingService.findAllAcademyRegistConsulting(academy);
//		model.addAttribute("registConsult",registConsult);
//		model.addAttribute("registConsultingList",registConsultingList);
//		return "eka_manager/consulting_edit";		
//	}
//	
//	
//	@PostMapping("eka_manager/update_consulting")
//	public String updateConsulting(Model model, @RequestParam String name,
//			@RequestParam String applyDate, @RequestParam String registDate,	@RequestParam String consultContent) throws ParseException {
//		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");		
//		Date to = fm.parse(applyDate);
//		Date now = fm.parse(registDate);		
//			
//		Academy academy = academyService.findAcademyByRegistationNum("11-11-11");		
//		Consulting updateConsult = consultingService.findAcademyConsultingByRegDateAndName(academy, to , name);
//		
//		updateConsult.setRegistDate(registDate);
//		updateConsult.setConsultContent(consultContent);
//		updateConsult.setConsultType("완료");		
//		
//		System.out.println(updateConsult);
//		
//		consultingService.updateConsulting(updateConsult);
//		
//		
//		List<Consulting> applyConsultingList = consultingService.findAllAcademyApplyConsulting(academy);		
//		model.addAttribute("applyConsultingList",applyConsultingList);
//		return "eka_manager/consulting_eka";
//		
//	}
//	
//	@PostMapping("eka_manager/update_regist_consulting")
//	public String updateRegistConsulting(Model model, @RequestParam String name,
//			@RequestParam String applyDate, @RequestParam String registDate,	@RequestParam String consultContent) throws ParseException {
//		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");		
//		Date to = fm.parse(applyDate);
//		Date now = fm.parse(registDate);		
//			
//		Academy academy = academyService.findAcademyByRegistationNum("11-11-11");		
//		Consulting updateConsult = consultingService.findAcademyRegistConsultingByRegDateAndName(academy, to , name);	
//		
//		updateConsult.setRegistDate(registDate);
//		updateConsult.setConsultContent(consultContent);
//		updateConsult.setConsultType("완료");		
//		
//		System.out.println(updateConsult);
//		
//	
//		System.out.println(consultingService.updateRegistConsulting(updateConsult));
//		
//
//		Consulting registConsult = consultingService.findAcademyRegistConsultingByRegDateAndName(academy, to , name);	
//		List<Consulting> registConsultingList = consultingService.findAllAcademyRegistConsulting(academy);
//		model.addAttribute("registConsult",registConsult);
//		model.addAttribute("registConsultingList",registConsultingList);
//		
//		
//		
//		return "eka_manager/consulting_edit";		
//	}
//	
//	
//	@PostMapping("eka_manager/add_regist_consulting")
//	public String addRegistConsulting(Model model, @RequestParam String name,
//			@RequestParam String phone1, @RequestParam String phone2, @RequestParam String phone3,
//			@RequestParam String applyDate, @RequestParam String registDate,@RequestParam String consultContent,
//			@RequestParam String consultCategory,@RequestParam String consultDetail) throws ParseException {
//		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");		
//		Date to = fm.parse(applyDate);
//		Date now = fm.parse(registDate);
//		
//		String phone = phone1+"-"+phone2+"-"+phone3;	
//		
//		Academy academy = academyService.findAcademyByRegistationNum("11-11-11");		
//		ConsultCategory csc = new ConsultCategory();
//		csc.setCategory(consultCategory);
//		
//		Consulting addConsult = new Consulting();
//		addConsult.setAcademy(academy);
//		addConsult.setApplyDate(applyDate);
//		addConsult.setConsultCategory(csc);
//		addConsult.setConsultContent(consultContent);
//		addConsult.setConsultDatail(consultDetail);
//		addConsult.setConsultType("완료");
//		addConsult.setName(name);
//		addConsult.setPhone(phone);
//		addConsult.setRegistDate(registDate);
//	
//		consultingService.addRegistConsulting(addConsult);	
//		
//		
//		return "eka_manager/consulting_unuser";		
//	}
//	
//	
//	@PostMapping("eka_manager/find_select_consulting")
//	public String findSelectConsulting(Model model, @RequestParam String name,
//			@RequestParam String applyDate, @RequestParam String registDate,
//			@RequestParam String consultCategory) throws ParseException {
//		System.out.println(name);
//		System.out.println(applyDate);
//		System.out.println(registDate);
//		System.err.println(consultCategory);
//		
//		
//		Academy academy = academyService.findAcademyByRegistationNum("11-11-11");		
//		ConsultCategory csc = new ConsultCategory();
//		csc.setCategory(consultCategory);
//		
//		
//		List<Consulting> registConsultingList = null;
//		
//		if(consultCategory == "" && applyDate == "" && registDate == "" && name == "") {
//			registConsultingList = consultingService
//					.findAllAcademyRegistConsulting(academy);
//		}else if(consultCategory != "" && applyDate == "" && registDate == "" && name == "") {
//			registConsultingList = consultingService
//					.findAllAcademyRegistConsultingByConsultCategory(academy,consultCategory);
//		}else if(consultCategory == "" && applyDate != "" && registDate == "" && name == "") {
//			registConsultingList = consultingService
//					.findAllAcademyRegistConsultingByApplyDate(academy,applyDate);
//		}else if(consultCategory == "" && applyDate == "" && registDate != "" && name == "") {
//			registConsultingList = consultingService
//					.findAllAcademyRegistConsultingByRegistDate(academy,registDate);
//		}else if(consultCategory == "" && applyDate == "" && registDate == "" && name != "") {
//			registConsultingList = consultingService
//					.findAllAcademyRegistConsultingByName(academy,name);
//		}else if(consultCategory != "" && applyDate != "" && registDate == "" && name == "") {
//			registConsultingList = consultingService
//					.findAllAcademyRegistConsultingByConsultCategoryAndApplyDate(academy,consultCategory,applyDate);
//		}else if(consultCategory != "" && applyDate == "" && registDate != "" && name == "") {
//			registConsultingList = consultingService
//					.findAllAcademyRegistConsultingByConsultCategoryAndRegistDate(academy,consultCategory,registDate);
//		}else if(consultCategory != "" && applyDate == "" && registDate == "" && name != "") {
//			registConsultingList = consultingService
//					.findAllAcademyRegistConsultingByConsultCategoryAndName(academy,consultCategory,name);
//		}else if(consultCategory == "" && applyDate != "" && registDate != "" && name == "") {
//			registConsultingList = consultingService
//					.findAllAcademyRegistConsultingByApplyDateAndRegistDate(academy,applyDate,registDate);
//		}else if(consultCategory == "" && applyDate != "" && registDate == "" && name != "") {
//			registConsultingList = consultingService
//					.findAllAcademyRegistConsultingByApplyDateAndName(academy,applyDate,name);
//		}else if(consultCategory == "" && applyDate == "" && registDate != "" && name != "") {
//			registConsultingList = consultingService
//					.findAllAcademyRegistConsultingByRegistDateAndName(academy,registDate,name);
//		}else if(consultCategory != "" && applyDate != "" && registDate != "" && name == "") {
//			registConsultingList = consultingService
//					.findAllAcademyRegistConsultingByConsultCategoryAndApplyDateAndRegistDate(academy,consultCategory,applyDate,registDate);
//		}else if(consultCategory != "" && applyDate != "" && registDate == "" && name != "") {
//			registConsultingList = consultingService
//					.findAllAcademyRegistConsultingByConsultCategoryAndApplyDateAndName(academy,consultCategory,applyDate,name);
//		}else if(consultCategory != "" && applyDate == "" && registDate != "" && name != "") {
//			registConsultingList = consultingService
//					.findAllAcademyRegistConsultingByConsultCategoryAndRegistDateAndName(academy,consultCategory,registDate,name);
//		}else if(consultCategory == "" && applyDate != "" && registDate != "" && name != "") {
//			registConsultingList = consultingService
//					.findAllAcademyRegistConsultingByApplyDateAndRegistDateAndName(academy,applyDate,registDate,name);
//		}else if(consultCategory != "" && applyDate != "" && registDate != "" && name != "") {
//			registConsultingList = consultingService
//					.findAllAcademyRegistConsultingByConsultCategoryAndApplyDateAndRegistDateAndName(academy,consultCategory,applyDate,registDate,name);
//		}
//		System.out.println(registConsultingList);
//		model.addAttribute("registConsultingList",registConsultingList);		
//		return "eka_manager/consulting_edit";		
//	}
//	
	
}
