package donemProjesi;

public class Transition {
	
	public static void transition(String x,int y) throws InterruptedException {
		
		for (int i = 0; i < 80; i++) {
            System.out.print(x);
            
            System.out.flush();
            Thread.sleep(y);
        }
		
		System.out.println("");
	}
	
	public static void intro() {
		
		System.out.println(RenkTerminal.RED_BOLD+"          _____         ___          __                   ____        __ ");
		System.out.println(RenkTerminal.BLUE_BOLD+"         /___ /____    /   |  ____  / /___ _____ ___     / __ )__  __/ / ");
		System.out.println(RenkTerminal.RED_BOLD+"        / __/ / ___/  / /  | / __  / / __ `/ __ `__ `   / __  / / / / /  ");
		System.out.println(RenkTerminal.BLUE_BOLD+"       / /___(__  )  / ___ |/ / / / / /_/ / / / / / /  / /_/ / /_/ / /   ");
		System.out.println(RenkTerminal.RED_BOLD+"      /_____/____/  /_/  |_/_/ /_/_/ __,_/_/ /_/ /_/  /_____/ __,_/_/    ");			
		System.out.println(RenkTerminal.RESET);		
	}
}
