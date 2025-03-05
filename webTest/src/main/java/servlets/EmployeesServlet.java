package servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

import dao.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns ="/employees")
public class EmployeesServlet extends HttpServlet {
		
	private EmployeeDAO dao;
	
		@Override
		public void init(ServletConfig config) throws ServletException {
			dao = new EmployeeDAOImpl(config.getServletContext());
		}	
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String operation = req.getParameter("operation");
			if("Cancel".equals(operation)) {
				req.setAttribute("emps",dao.getAll());
				req.getRequestDispatcher("employees.jsp").forward(req, resp);
				return;
			}
			Employee emp =Employee.builder().id(Integer.parseInt(req.getParameter("id")))
					.name(req.getParameter("name"))
					.age(Integer.parseInt(req.getParameter("age")))
					.gender(req.getParameter("gender").toUpperCase())
					.salary(Integer.parseInt(req.getParameter("salary")))
					.exp(Integer.parseInt(req.getParameter("experience")))
					.level(Integer.parseInt(req.getParameter("level"))).build();
			
			
			if("Save".equals(operation)) {

				dao.save(emp);
				req.setAttribute("emps",dao.getAll());
				req.getRequestDispatcher("employees.jsp").forward(req, resp);
				return;
			}
			if("Update".equals(operation)) {
				dao.update(emp);
				req.setAttribute("emps", dao.getAll());
				req.getRequestDispatcher("employees.jsp").forward(req, resp);
				return;	
			}
		}
			
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String operation = req.getParameter("operation");
			
			if("Update".equals(operation)) {
				int id = Integer.parseInt(req.getParameter("id"));
				Employee e = dao.get(id);
				req.setAttribute("readonly", "readonly");			
				req.setAttribute("emp", e);
				req.setAttribute("mode", "Update");
				req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
			return;
			} 
			if("Delete".equals(operation)) {
				int id = Integer.parseInt(req.getParameter("id"));
				dao.delete(id);
				req.setAttribute("emps", dao.getAll());
				req.getRequestDispatcher("employees.jsp").forward(req, resp);
				return;
			}
			
			
			if("new".equals(operation)) {
				req.setAttribute("mode","Save");
				req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
				return;
			}  
			
			String searchName = (String) req.getParameter("searchOption");  
			System.out.println(searchName + "......");
			if("name".equals(searchName)) {
				System.out.println("....");
				req.setAttribute("emps",dao.searchEmployeesByName(req.getParameter("search_value")));
				System.out.println("search value-........"+ req.getParameter("search_value"));
				System.out.println(dao.searchEmployeesByName(req.getParameter("search_value").toLowerCase()));
				req.getRequestDispatcher("employees.jsp").forward(req, resp);
				return;
			}
			
			else if ("age".equals(searchName)) {
				req.setAttribute("emps",dao.searchEmployeesByAge(Integer.parseInt(req.getParameter("search_value"))));
				req.getRequestDispatcher("employees.jsp").forward(req, resp);
			}
		
			else if ("salary".equals(searchName)) {
				req.setAttribute("emps",dao.searchEmployeesBySalary(Double.parseDouble(req.getParameter("search_value"))));
				req.getRequestDispatcher("employees.jsp").forward(req,resp);
			}
			
			else if ("level".equals(searchName)) {
				req.setAttribute("emps",dao.searchEmployeesByLevel(Integer.parseInt(req.getParameter("search_value"))));
				req.getRequestDispatcher("employees.jsp").forward(req, resp);
			}
			
			
			
			
//			else if ("experience".equals(searchName)) {
//				req.setAttribute("emps",dao.searchEmployeesByExperience(Integer.parseInt(req.getParameter("search_value"))));
//				req.getRequestDispatcher("employees.jsp").forward(req, resp);
//			}
			else if ("experience".equals(searchName)) {
				req.setAttribute("emps", dao.searchEmployeesByExperience(Integer.parseInt(req.getParameter("search_value"))));
				req.getRequestDispatcher("employees.jsp").forward(req, resp);
			}
			
			
			
		
			
//			else if ("Salary".equals(searchName)) {
//				req.setAttribute("emps",dao.searchEmployeesBySalary(Double.parseDouble(req.getParameter("search_value"))));
//				req.getRequestDispatcher("employees.jsp").forward(req, resp);
//				
//				return;
//			}
			

	
			
			else {
				System.out.println("aaaaaaaaaaaaaaaaaa-------");
				String sortBy = req.getParameter("sortBy");
				String sortOrder = req.getParameter("sortOrder");
				if(sortOrder == null) {
					sortOrder = "ascending";
				}
				if("byName".equals(sortBy)){
					
				
				
				if("descending".equals(sortOrder)) {
					System.out.println("descccccccccccccccccccccc");
					req.setAttribute("emps", dao.sortedEmployeesByNameDesc());
//					return;
				}
				else if("ascending".equals(sortOrder)) {
					req.setAttribute("emps", dao.sortedEmployeesByName());
					System.out.println("ascccccccccccccccccccccc");
//				return;
					}
				}
				else if("byId".equals(sortBy)) {
					
					if("descending".equals(sortOrder)) {
						System.out.println("descccccccccccccccccccccc");
						req.setAttribute("emps", dao.sortedEmployeesByIdDesc());
//						return;
					}
					else if("ascending".equals(sortOrder)) {
						req.setAttribute("emps", dao.sortedEmployeesById());
						System.out.println("ascccccccccccccccccccccc");
					
//						return ;
						
						}
					
				}
				//////////////////////////////////// // BY AGE
	
				else if("byAge".equals(sortBy)) {
					
					if("descending".equals(sortOrder)) {
						System.out.println("descccccccccccccccccccccc");
						req.setAttribute("emps", dao.sortedEmployeesByAgeDesc());
//						return;
					}
					else if("ascending".equals(sortOrder)) {
						req.setAttribute("emps", dao.sortedEmployeesByAge());
						System.out.println("ascccccccccccccccccccccc");
				
					}
				}
				
				
				//////////////////////////////////////////// //BY SALARY
					else if("bySalary".equals(sortBy)) {
					
					if("descending".equals(sortOrder)) {
						System.out.println("descccccccccccccccccccccc");
						req.setAttribute("emps", dao.sortedEmployeesBySalaryDesc());
//						return;
					}
					else if("ascending".equals(sortOrder)) {
						req.setAttribute("emps", dao.sortedEmployeesBySalary());
						System.out.println("ascccccccccccccccccccccc");
						}
					}
				
				/////////////////////////////////////// //BY GENDER
					else if("byGender".equals(sortBy)) {
						
						if("descending".equals(sortOrder)) {
							System.out.println("descccccccccccccccccccccc");
							req.setAttribute("emps", dao.sortedEmployeesByGenderDesc());
//							return;
						}
						else if("ascending".equals(sortOrder)) {
							req.setAttribute("emps", dao.sortedEmployeesByGender());
							System.out.println("ascccccccccccccccccccccc");
						}
					}
			
				///////////////////////////////////////////// //BY LEVEL
				
					else if("byLevel".equals(sortBy)) {
						
						if("descending".equals(sortOrder)) {
							System.out.println("workinggg");
							req.setAttribute("emps", dao.sortedEmployeesByLevelDesc());
//							return;
						}
						else if("ascending".equals(sortOrder)) {
							req.setAttribute("emps", dao.sortedEmployeesByLevel());
							System.out.println("workinggg");
						}
					}			
				
				///////////////////////////////////////////////////// //BY EXP
				
					else if("byExp".equals(sortBy)) {
						
						if("descending".equals(sortOrder)) {
							System.out.println("workingggggg");
							req.setAttribute("emps", dao.sortedEmployeesByExperienceDesc());
//							return;
						}
						else if("ascending".equals(sortOrder)) {
							req.setAttribute("emps", dao.sortedEmployeesByExperience());
							System.out.println("workingggg");
				
						}
					}		
				
				//////////////////////////////////////////////////////////
				else {
					if("descending".equals(sortOrder)) {
						System.out.println("descccccccccccccccccccccc");
						req.setAttribute("emps", dao.sortedEmployeesByIdDesc());
//						return;
					}
					else if("ascending".equals(sortOrder)) {
						req.setAttribute("emps", dao.sortedEmployeesById());
						System.out.println("ascccccccccccccccccccccc");
					
//						return ;
						
						}
					
				}
				req.setAttribute("sortOrder", sortOrder);
				req.getRequestDispatcher("employees.jsp").forward(req, resp);

				
			
			} 
		
			
//			req.setAttribute("emps", dao.getAll());
//			req.getRequestDispatcher("employees.jsp").forward(req, resp);
		}

}
