package application;

public class LetterTemplate {
	
	public static final String COURSES_TEMPLATE_PREFIX = "<He/She> also earned ";
	public static final String COURSES_TEMPLATE_REPEAT = "\"<letter grade>\" from my \"<course name>\"";
	public static final String TERM_PROJECT_TEMPLATE = "Furthermore, I noticed from the term project result, <he/she> developed leadership, time management, and problem-solving skills. <He/She> worked effectively with the team members and delegated tasks appropriately. They were able to deliver a successful project in a timely fashion.\n";
	
	public static final String TEMPLATE = 
			"Letter of Recommendation\n"
			+ "For: <Student's Full Name>\n" + "\n"
			+ "Date: <Today's Date>\n" + "\n"
			+ "To: Graduate Admissions Committee\n"
			+ "I am writing this letter to recommend my former student <Student's Full Name> who is applying for the <program name> in your school.\n"
			+ "I met <Student's First Name> in <First Semester> when he enrolled in my \"<First Course Taken>\" course.\n"
			+ "<Student's First Name> earned <letter grade> from this tough course, and this shows how knowledgeable and hard worker <he/she> is.\n"
//			+ "{If the student took more courses with this professor, the coma-separated list of them plus the grades earned are listed in the following paragraph.}\n"
//			+ "[<He/She> also earned \"<letter grade>\" from my \"<course name>\"[, \"<letter grade>\" from my \"<course name>\"[, ...]]] <course/courses>.\n"
			+ "<additional-course-info>"
			+ "<Student's First Name> <Coma separated Academic Characteristics>.\n"
			+ "<He/She> was always <Coma separated Personal Characteristics>.\n"
//			+ "{Keep the following paragraph here just in case the student developed a term project. If not, it can be deleted by the user during editing.}\n"
//			+ "Furthermore, I noticed from the term project result, <he/she> developed leadership, time management, and problem-solving skills. <He/She> worked effectively with the team members and delegated tasks appropriately. They were able to deliver a successful project in a timely fashion.\n"
			+ "<term-project-info>"
			+ "I believe that <Student's First Name> has the capacity to excel at higher education program and this is my pleasure to highly recommend him.\n"
			+"\n"
			+ "Please do not hesitate to contact me with further questions.\n"
			+"\n"
			+"\n"
			+ "Very Respectfully,\n"
			+"\n"
			+ "<Professor's Full Name>\n"
			+"\n"
			+ "<Professor's title>\n"
			+ "<School's name, department's name>\n"
			+ "<Professor's email address>\n"
			+ "<Professor's phone number>";

}
