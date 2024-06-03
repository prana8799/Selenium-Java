package BookMyShowMovieBookings;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MovieDay1 {
	
	@Test
	public void moviebookingday1() {
		System.out.println("The booking is yet to open. Pls wait!");
	}
	
	
	@AfterMethod(timeOut = 2000L)
	public void goatfilm() {
		System.out.println("The booking for Thalapathy Vijay starrer GOAT will open shortly");
	}

	
	@BeforeMethod
	public void nowshowing() {
		System.out.println("You can book tickets for the movie running currently");
	}


@Parameters({"movie-name"})
@Test
public void moviename(String Movie) {
	System.out.println(Movie);
	assert "GOAT".equals(Movie);
}
}
