package hu.progmatic.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructorTests {

    private final Client[] clients = {
            new Client("A01"),
            new Client("A02", "Kis Pista", "Nagykovácsi, Kitalált utca 1.", "+3630/0000000", "kispista@gmail.com")
    };

    private final TyreSet[] tyreSets = {
            new TyreSet(),
            new TyreSet(clients[1], false, "Kumho", 3.2, true, 4, "none")
    };

    private final StoredSet storedSet = new StoredSet(clients[1], tyreSets[1], true, "2022.10.20");


    @Test
    void clientConstructorTest() {
        assertEquals("A01", clients[0].getId());
        assertNull(clients[0].getName());

        assertEquals("A02", clients[1].getId());
        assertEquals("Kis Pista", clients[1].getName());
        assertEquals("Nagykovácsi, Kitalált utca 1.", clients[1].getAddress());
        assertEquals("+3630/0000000", clients[1].getPhoneNumber());
        assertEquals("kispista@gmail.com", clients[1].getEmail());
    }

    @Test
    void tyreSetConstructorTest() {
        assertNull(tyreSets[0].getBrand());

        assertEquals("Kis Pista", tyreSets[1].getOwner().getName());
        assertFalse(tyreSets[1].isWheel());
        assertEquals("Kumho", tyreSets[1].getBrand());
        assertEquals(3.2, tyreSets[1].getTreadDepht());
        assertTrue(tyreSets[1].isSummerTread());
        assertEquals(4, tyreSets[1].getNumOfTyresInSet());
        assertEquals("none", tyreSets[1].getDamages());
    }

    @Test
    void storedSetConstructorTest() {
        storedSet.setFleetInfo("Pista Kft.");

        assertEquals("Nagykovácsi, Kitalált utca 1.", storedSet.getClient().getAddress());
        assertEquals("none", storedSet.getTyreSet().getDamages());
        assertTrue(storedSet.isFleet());
        assertEquals("Pista Kft.", storedSet.getFleetInfo());
        assertEquals("2022.10.20", storedSet.getPaidUntil());
    }
}