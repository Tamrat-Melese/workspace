package com.mpp.lab10.prob2.bugreporter;


import com.mpp.lab10.prob2.classfinder.ClassFinder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * This class scans the package com.mpp.lab10.prob2.javapackage
 * for classes with annotation @BugReport. It then generates a bug report
 * bugreport.txt, formatted like this:
 * 
 * Joe Smith
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *     
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *     
 * Tom Jones
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *     
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 * 
 *
 */
public class BugReportGenerator {
	private static final Logger LOG = Logger.getLogger(BugReportGenerator.class.getName());
	private static final String PACKAGE_TO_SCAN = "com.mpp.lab10.prob2.javapackage";
	private static final String REPORT_NAME = "bug_report.txt";
	private static final String REPORTED_BY = "reportedBy: ";
	private static final String CLASS_NAME = "classname: ";
	private static final String DESCRIPTION = "description: ";
	private static final String SEVERITY = "severity: ";
	private static final String INDENT = "  ";

	public void reportGenerator() {
		List<Class<?>> classes = ClassFinder.find(PACKAGE_TO_SCAN);
		//implement
		Map<String, List<Class<?>>> bugByDeveloper = classes
				.stream()
				.filter(c -> c.isAnnotationPresent(BugReport.class))
				.collect(Collectors.groupingBy(c -> ((BugReport)c.getAnnotation(BugReport.class)).assignedTo()));

		StringBuilder sb = new StringBuilder();

		bugByDeveloper.forEach((assignedTo, clazzes) -> {
			sb.append(assignedTo).append("\n");
			clazzes.forEach(clazz -> {
				BugReport br = (BugReport) clazz.getAnnotation(BugReport.class);

				sb.append(INDENT).append(REPORTED_BY).append(br.reportedBy()).append("\n")
					.append(INDENT).append(CLASS_NAME).append(clazz.toString()).append("\n")
					.append(INDENT).append(DESCRIPTION).append(br.description()).append("\n")
					.append(INDENT).append(SEVERITY).append(br.severity()).append("\n\n");
			});
		});

		try {
			FileWriter fw = new FileWriter(REPORT_NAME);
			fw.write(sb.toString());
			fw.close();
		} catch (IOException e){
			LOG.log(Level.SEVERE, e.toString());
		}
	}
}
