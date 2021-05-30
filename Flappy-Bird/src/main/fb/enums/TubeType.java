package main.fb.enums;

/**
 * An enum to specify where the gap between the tubes is
 */
public enum TubeType
{
    BOTTOM("BOTTOM", 0), 
    TOP("TOP", 1);
    
    private TubeType(final String name, final int ordinal) {
    }
}