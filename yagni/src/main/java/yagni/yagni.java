public class Yagni {
	public static void main(String[] args) {
		UserRepository userRepository=new UserRepository();
		userRepository.getAll();
	}
}
	class UserRepository{
		public void getAll() {
			System.out.println("returned all users");
		}
		/**private void getById() {
		System.out.println("returned user by id");
		}
		private void getByName() {
			System.out.println("returned user by name");
		}
		private void getByAge() {
			System.out.println("returned user by age");
		}**/
	}
