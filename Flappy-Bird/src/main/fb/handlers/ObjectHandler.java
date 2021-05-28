package main.fb.handlers;

import java.awt.Graphics;
import java.util.LinkedList;

import main.fb.supers.GameObject;

/**
 * A class that saves objects like the bird and tubes to be able to render/tick them all at once
 */
public class ObjectHandler
{
    public static LinkedList<GameObject> list;
    public static int index;
    
    static {
        ObjectHandler.list = new LinkedList<GameObject>();
        ObjectHandler.index = -1;
    }
    
    public static void addObject(final GameObject o) {
        ObjectHandler.list.add(o);
    }
    
    public static void removeObject(final GameObject o) {
        ObjectHandler.list.remove(o);
    }
    
    public static void render(final Graphics g) {
        GameObject temp = null;
        for (int i = 0; i < ObjectHandler.list.size(); ++i) {
            temp = ObjectHandler.list.get(i);
            temp.render(g);
        }
    }
    
    public static void tick() {
        GameObject temp = null;
        for (int i = 0; i < ObjectHandler.list.size(); ++i) {
            temp = ObjectHandler.list.get(i);
            temp.tick();
        }
    }

    public static boolean hasNext() {
        return ObjectHandler.index < ObjectHandler.list.size();
      }
   
    public GameObject next() {
        return ObjectHandler.list.get(ObjectHandler.index);
    }
}