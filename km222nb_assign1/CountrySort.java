package km222_nb_assign1;

import java.util.Arrays;
import java.util.Comparator;

// Might have made a few changes of my own... but should give the same output anyways! 
public class CountrySort {

	public static void main(String[] args) {

		// Here we print the top ten of a list with countries with the longest names.
		Comparator<String> longestName = (s1, s2) -> s2.length() - s1.length(); // Must be updated
		Arrays.sort(COUNTRIES, longestName);
		System.out.println("\nCountries with longest names");
		for (int i = 0; i < 10; i++)
			System.out.println("\t" + COUNTRIES[i]);

		// Here we print the top ten of the countries that start their names in the
		// alphabetical order in reverse.
		Comparator<String> reverseAlphabetic = (s1, s2) -> s2.compareTo(s1); // Must be updated
		Arrays.sort(COUNTRIES, reverseAlphabetic);
		System.out.println("\nCountries in reverse alphabetic order");
		for (int i = 0; i < 10; i++)
			System.out.println("\t" + COUNTRIES[i]);
		// And here we print the countries with the most "A/s" in it.
		Comparator<String> countAs = (s1, s2) -> {
			int s1Counter = 0;
			int s2Counter = 0;
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) == 'a' || s1.charAt(i) == 'A') {
					s1Counter++;
				}
			}
			for (int j = 0; j < s2.length(); j++) {
				if (s2.charAt(j) == 'a' || s2.charAt(j) == 'A') {
					s2Counter++;
				}
			}
			return s2Counter - s1Counter;
		};
		Arrays.sort(COUNTRIES, countAs);
		System.out.println("\nCountry names containing most A's. Upper or lowercases : ");
		for (int i = 0; i < 10; i++)
			System.out.println("\t" + COUNTRIES[i]);

	}

	// Might have missed a country or two... not sure.
	// Could have copied everything and added them into an file and just read each
	// word... But this worked.

	private static String[] COUNTRIES =  {
		    "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
		    "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
		    "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan",
		    "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium",
		    "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
		    "Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory",
		    "British Virgin Islands", "Brunei", "Bulgaria", "Burkina Faso", "Burundi",
		    "Cote d'Ivoire", "Cambodia", "Cameroon", "Canada", "Cape Verde",
		    "Cayman Islands", "Central African Republic", "Chad", "Chile", "China",
		    "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo",
		    "Cook Islands", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic",
		    "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
		    "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea",
		    "Estonia", "Ethiopia", "Faeroe Islands", "Falkland Islands", "Fiji", "Finland",
		    "Former Yugoslav Republic of Macedonia", "France", "French Guiana", "French Polynesia",
		    "French Southern Territories", "Gabon", "Georgia", "Germany", "Ghana", "Gibraltar",
		    "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau",
		    "Guyana", "Haiti", "Heard Island and McDonald Islands", "Honduras", "Hong Kong", "Hungary",
		    "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica",
		    "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos",
		    "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg",
		    "Macau", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands",
		    "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia", "Moldova",
		    "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia",
		    "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand",
		    "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "North Korea", "Northern Marianas",
		    "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru",
		    "Philippines", "Pitcairn Islands", "Poland", "Portugal", "Puerto Rico", "Qatar",
		    "Reunion", "Romania", "Russia", "Rwanda", "Sqo Tome and Principe", "Saint Helena",
		    "Saint Kitts and Nevis", "Saint Lucia", "Saint Pierre and Miquelon",
		    "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Saudi Arabia", "Senegal",
		    "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands",
		    "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "South Korea",
		    "Spain", "Sri Lanka", "Sudan", "Suriname", "Svalbard and Jan Mayen", "Swaziland", "Sweden",
		    "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "The Bahamas",
		    "The Gambia", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey",
		    "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Virgin Islands", "Uganda",
		    "Ukraine", "United Arab Emirates", "United Kingdom",
		    "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan",
		    "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Wallis and Futuna", "Western Sahara",
		    "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"
		  };
}