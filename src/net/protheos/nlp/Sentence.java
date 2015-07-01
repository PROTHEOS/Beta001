/**
 * Project: Beta001
 * Package: net.protheos.brain.nlp
 * Filename: Sentence.java
 * Date: 30/05/2015
 * Time: 08:05:50
 * Developer: "Marcelo Gagliano"
 */
package net.protheos.nlp;

/**
 * @author "Marcelo Gagliano"
 *
 */

/**
	 * Date: 30/05/2015
	 * Time: 08:05:51
	 * Developer: "Marcelo Gagliano"
	 * Objective: <>
	 * Receive: Sentence
	 * Return: net.protheos.brain.nlp.Sentence.java
	 * TODO: TODO
	 * Tags:
	 */

public class Sentence {

		private String subject = "";
		private String verb = "";
		private String object = "";

		private boolean question = false;
		private boolean affirmative = false;


		public Sentence() {
			super();
			subject = "";
			verb = "";
			object = "";
			// TODO Auto-generated constructor stub
		}

		public Sentence(String rawSentence) {
			super();
			this.tokenize(rawSentence);
		}


		public void tokenize(String rawSentence){
			String st1 = rawSentence.substring(0, rawSentence.indexOf(" "));

			String st2 = rawSentence.substring(rawSentence.indexOf(" ") + 1, rawSentence.indexOf(" ", rawSentence.indexOf(" ") + 1));

			String st3 = rawSentence.substring(st1.length() + 1 + st2.length() + 1);

			setSubject(st1);
			setVerb(st2);
			setObject(st3);
			question = false;
			affirmative = true;

			if (st1.equalsIgnoreCase("IS")) {
				question = true;
				affirmative = false;
				setVerb(st1);
				setSubject(st2);
			}

			if (st1.equalsIgnoreCase("ARE")) {
				question = true;
				affirmative = false;
				setVerb(st1);
				setSubject(st2);
			}
		}


		public String getSubject() {
			return subject;
		}


		public void setSubject(String subject) {
			this.subject = subject;
		}


		public String getVerb() {
			return verb;
		}


		public void setVerb(String verb) {
			this.verb = verb;
		}


		public String getObject() {
			return object;
		}


		public void setObject(String object) {
			this.object = object;
		}


		public boolean isQuestion() {
			return question;
		}


		public void setQuestion(boolean question) {
			this.question = question;
		}


		public boolean isAffirmative() {
			return affirmative;
		}


		public void setAffirmative(boolean affirmative) {
			this.affirmative = affirmative;
		}

	}
