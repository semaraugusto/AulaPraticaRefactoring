import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnitTest {

	@Test
	void testStatement() {
    Customer customer = new Customer("Joao");

    Movie matrix  = new Movie("Matrix", 10);
    Movie matrix_ii  = new Movie("Matrix II", 10);
    Movie matrix_iii  = new Movie("Matrix III", 10);

		assertEquals(customer.statement(), "Rental Record for Joao\n" +
                                           "Amount owed is 0.0\n" +
				                           "You earned 0 frequent renter points");

		Rental rental1 = new Rental(matrix, 10);
		customer.addRental(rental1);

		assertEquals(customer.statement(), "Rental Record for Joao\n" +
                                           "Matrix  10.0\n" +
				                           "Amount owed is 10.0\n" +
				                           "You earned 1 frequent renter points");

		Rental rental2 = new Rental(matrix_ii, 10);
		customer.addRental(rental2);
		Rental rental3 = new Rental(matrix_iii, 10);
		customer.addRental(rental3);

        assertEquals(customer.statement(), "Rental Record for John Doe\n" +
		                           		   "	Matrix  10.0\n" +
				                           "	Matrix II   10.0\n" +
				                           "	Matrix III  10.0\n" +
				                           "Amount owed is 30.0\n" +
				                           "You earned 3 frequent renter points");
	}

}
