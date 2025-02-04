public class VedadKruhoMainStack {
    public static void main(String[] args) {
        VedadKruhoStack stacks = new VedadKruhoStack(20);

        
        stacks.pushStack1(1);
        stacks.pushStack1(2);
        stacks.pushStack1(3);
        stacks.pushStack1(4);
        stacks.pushStack1(5);

        stacks.pushStack2(6);
        stacks.pushStack2(7);
        stacks.pushStack2(8);
        stacks.pushStack2(9);
        stacks.pushStack2(10);

        stacks.pushStack3(11);
        stacks.pushStack3(12);
        stacks.pushStack3(13);
        stacks.pushStack3(14);
        stacks.pushStack3(15);

        stacks.pushStack4(16);
        stacks.pushStack4(17);
        stacks.pushStack4(18);
        stacks.pushStack4(19);
        stacks.pushStack4(20);
        stacks.popStack4();

        System.out.println("Example 1: Normal operations without error");
        stacks.displayArray();

        // Example 2: Overflow condition IF THERE IS NO POP OPERATION
        stacks.pushStack1(21); 
        stacks.pushStack3(23); 
        stacks.pushStack4(24); 

        System.out.println("Example 2: Overflow condition");
        stacks.displayArray();
    }
}