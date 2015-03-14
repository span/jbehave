package net.danielkvist.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CellSteps {
	
	private boolean cellIsDead;
	private int numberOfLiveNeighbors;

	@Given("a dead cell")
	public void givenADeadCell() {
		this.cellIsDead = true;
	}

	@When("the cell evolves to the next generation")
	public void whenTheCellEvolvesToTheNextGeneration() {
		this.cellIsDead = this.numberOfLiveNeighbors > 3;
	}

	@Then("the cell is now alive")
	public void thenTheCellIsNowAlive() {
		assertFalse(cellIsDead);
	}
	
	@Given("a live cell")
	public void givenALiveCell() {
	  this.cellIsDead = false;
	}

	@Given("the cell has $livecells live neighbors")
	public void givenTheCellHasLiveNeighbors(int livecells) {
		this.numberOfLiveNeighbors = livecells;
	}

	@Then("the cell is now dead")
	public void thenTheCellIsNowDead() {
		assertTrue(this.cellIsDead);
	}
}
