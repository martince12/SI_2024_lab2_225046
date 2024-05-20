public class SILab2Test {

    @Test
    void testEveryBranch() {
        // Test Case 1
        RuntimeException exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100));
        assertEquals("allItems list can't be null!", exception.getMessage());

        // Test Case 2: 
        List<Item> items = new ArrayList<>();
        assertTrue(SILab2.checkCart(items, 100));

        // Test Case 3: 
        items.add(new Item(null, "12345", 100, 0.1f));
        assertTrue(SILab2.checkCart(items, 100));

        // Test Case 4: 
        items.set(0, new Item("", "12345", 100, 0.1f));
        assertTrue(SILab2.checkCart(items, 100));

        // Test Case 5: 
        items.set(0, new Item("item1", null, 100, 0.1f));
        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, 100));
        assertEquals("No barcode!", exception.getMessage());

        // Test Case 6: 
        items.set(0, new Item("item1", "12a45", 100, 0.1f));
        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, 100));
        assertEquals("Invalid character in item barcode!", exception.getMessage());

        // Test Case 7: 
        items.set(0, new Item("item1", "12345", 100, 0.2f));
        assertTrue(SILab2.checkCart(items, 80));

        // Test Case 8: 
        items.set(0, new Item("item1", "12345", 100, 0.0f));
        assertTrue(SILab2.checkCart(items, 100));

        // Test Case 9: 
        items.set(0, new Item("item1", "012345", 400, 0.1f));
        assertTrue(SILab2.checkCart(items, 340));

        // Test Case 10: 
        items.set(0, new Item("item1", "12345", 100, 0.1f));
        assertFalse(SILab2.checkCart(items, 50));

        // Test Case 11: 
        assertTrue(SILab2.checkCart(items, 90));
    }

    // Test cases za Multiple Condition criterion
    @Test
    void testMultipleCondition() {
        // Test Case 1: 
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "012345", 400, 0.1f));
        assertTrue(SILab2.checkCart(items, 340));

        // Test Case 2: 
        items.set(0, new Item("item1", "012345", 200, 0.1f));
        assertTrue(SILab2.checkCart(items, 180));

        // Test Case 3:
        items.set(0, new Item("item1", "012345", 400, 0.0f));
        assertTrue(SILab2.checkCart(items, 400));

         // Test Case 4 
        items.set(0, new Item("item1", "112345", 400, 0.1f));
        assertTrue(SILab2.checkCart(items, 360));

        // Test Case 5: 
        items.set(0, new Item("item1", "012345", 200, 0.0f));
        assertTrue(SILab2.checkCart(items, 200));
        
        // Test Case 6: 
        items.set(0, new Item("item1", "012345", 400, 0.1f));
        assertTrue(SILab2.checkCart(items, 340));

        // Test Case 7: 
        items.set(0, new Item("item1", "012345", 200, 0.1f));
        assertTrue(SILab2.checkCart(items, 180));

        // Test Case 8: 
        items.set(0, new Item("item1", "012345", 400, 0.0f));
        assertTrue(SILab2.checkCart(items, 400));