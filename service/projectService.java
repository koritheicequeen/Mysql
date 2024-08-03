package projects.service;

import project.entity.Project;
import projects.dao.ProjectDao;

public class projectService {
	private static ProjectDao projectDao = new ProjectDao();

	public static Project addProject(Project project) {
			  return projectDao.insertProject(project);

			
	}
	

}
