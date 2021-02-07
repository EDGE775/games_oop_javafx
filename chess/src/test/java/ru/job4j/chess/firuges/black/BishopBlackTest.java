package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenFindPosition() {
        Cell cell = Cell.findBy(2, 4);
        BishopBlack bishop = new BishopBlack(cell);
        Cell expected = bishop.position();
        assertThat(cell, is(expected));
    }

    @Test
    public void whenCorrectWay() throws ImpossibleMoveException {
        Cell cell = Cell.C1;
        BishopBlack bishop = new BishopBlack(cell);
        Cell[] wayArray = bishop.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(expected, is(wayArray));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenUnCorrectWay() throws ImpossibleMoveException {
        Cell cell = Cell.C1;
        BishopBlack bishop = new BishopBlack(cell);
        bishop.way(Cell.G1);
    }

    @Test
    public void whenMakeCopy() {
        Cell cell = Cell.findBy(1, 1);
        BishopBlack bishop = new BishopBlack(cell);
        Cell dest = Cell.findBy(5, 4);
        assertThat(dest, is(bishop.copy(dest).position()));
    }
}