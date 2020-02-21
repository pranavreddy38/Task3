package dry;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
	public String main(String[] args) {
		List<Girls> girls=new ArrayList<>();
		girls.add(new Girls("Jessica","9745387292"));
		System.out.println("Give me the Jessica number");
		getGirl(girls,"Jessica");
	}
	private static void getGirl(List<Girls> girls,String girlName) {
		List<Girls> girl=girls.stream().filter(row->girlName.equals(row.getName())).collect(Collectors.toList());
		String phone=girl.get(0).getPhone();
		System.out.println(phone);
	}
}
class Girls{
	private String name;
	private String phone;
	public Girls(String name,String phone) {
		this.name=name;
		this.phone=phone;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}

}