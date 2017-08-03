package extra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManageServices {
	
	/*
	 * Converts the services string separated by "->" to a list of services
	 */
	
	public Set<String> allowedServices = new HashSet<String>();
	public ManageServices() {
		allowedServices.add("seniorHousing");
		allowedServices.add("inHomeCare");
		allowedServices.add("vendorService");
		allowedServices.add("legal");
		allowedServices.add("taxation");
		allowedServices.add("financialPlanning");
		allowedServices.add("insurance");
		allowedServices.add("estatePlanning");
		
	}
	public List<String> stringToServices (String services) {
		if (services == null || services.length() == 0) {
			return null;
		}
		String[] strs = services.split("->");
		Set<String> set = new HashSet<String>();
		List<String> result = new ArrayList<String>();
		for (String s: strs) {
			if (!set.contains(s) && allowedServices.contains(s)) {
				result.add(s);
				set.add(s);
			}
		}
		return result;
		
	}
	
	public String ListtoString (List<String> services) {
		if (services == null || services.size() == 0) {
			return null;
		}
		Set<String> set = new HashSet<String>();
		StringBuffer result = new StringBuffer();
		for (String s: services) {
			if (!set.contains(s) && allowedServices.contains(s)) {
				result.append(s);
				result.append("->");
				set.add(s);
			}
		}
		if (result.length() > 0 && result.charAt(result.length()-1) == '>') {
			result.delete(result.length()-2, result.length());
		}
		return result.toString();
		
	}
}
