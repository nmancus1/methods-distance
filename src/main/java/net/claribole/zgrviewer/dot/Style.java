/*   FILE: Style.java
 *   DATE OF CREATION:   Apr 4 2005
 *   AUTHOR :            Eric Mounhem (skbo@lri.fr)
 *   Copyright (c) INRIA, 2004-2005. All Rights Reserved
 *   Licensed under the GNU LGPL. For full terms see the file COPYING.
 * 
 * $Id: Style.java 576 2007-03-29 18:32:53Z epietrig $
 */

package net.claribole.zgrviewer.dot;

/**
 * Specifies a node or edge style. It can be one of the predefined style or
 * a new one, which can have attributes
 * @author Eric Mounhem
 */
public class Style {
    /**
     * Styles not predefined
     */
    public CustomStyle[] getOtherStyles() {
        return otherStyles;
    }

    public void setOtherStyles(CustomStyle[] otherStyles) {
        this.otherStyles = otherStyles;
    }

    /**
     * Save (maybe parameterized) styles that are not predefined
     * @author Eric Mounhem
     */
    class CustomStyle {
        /**
         * Style's name
         */
        String   name;
        /**
         * Style's arguments
         */
        Object[] arguments = null;

        /**
         * @see Object#toString()
         */
        public String toString() {
            String s = this.name;
            if (this.arguments != null) {
                s += "(";
                for (int i = 0; i < this.arguments.length; i++) {
                    if (i > 0)
                        s += ",";
                    s += this.arguments[i];
                }
                s += ")";
            }
            return s;
        }
    }

    private CustomStyle[]         otherStyles        = null;

    /**
     * Dashed style modifier
     */
    public final static int      DASHED             = 0;
    /**
     * Dotted style modifier
     */
    public final static int      DOTTED             = 1;
    /**
     * Solid style modifier
     */
    public final static int      SOLID              = 2;
    /**
     * Invisible style modifier
     */
    public final static int      INVIS              = 3;
    /**
     * Bold style modifier
     */
    public final static int      BOLD               = 4;
    /**
     * Filled style modifier
     */
    public final static int      FILLED             = 5;
    /**
     * Diagonals style modifier
     */
    public final static int      DIAGONALS          = 6;
    /**
     * Rounded style modifier
     */
    public final static int      ROUNDED            = 7;
    /**
     * Values of node styles
     */
    private boolean[]     styles             = { false, false, false, false,
            false, false, false, false      };                                   // new boolean[8];
    /**
     * Name of style attributes
     */
    final static String[] styleAttributeName = { "dashed", "dotted", "solid",
            "invis", "bold", "filled", "bold", "filled", "diagonals", "rounded" };

    /**
     * Set the style of a node
     * @param style one of the following:
     * <ul>
     * <li>DASHED</li>
     * <li>DOTTED</li>
     * <li>SOLID</li>
     * <li>INVIS</li>
     * <li>BOLD</li>
     * <li>FILLED</li>
     * <li>DIAGONALS</li>
     * <li>ROUNDED</li>
     * </ul>
     * @param value value you want to apply to a style
     */
    public void setStyle(int style, boolean value) {
        this.styles[style] = value;
    }

    /**
     * Get the style of a node
     * @param s One of the following style:
     * <ul>
     * <li>DASHED</li>
     * <li>DOTTED</li>
     * <li>SOLID</li>
     * <li>INVIS</li>
     * <li>BOLD</li>
     * <li>FILLED</li>
     * <li>DIAGONALS</li>
     * <li>ROUNDED</li>
     * </ul>
     * @return State of a style (activated or not)
     */
    public boolean getStyle(int s) {
        return this.styles[s];
    }

    /**
     * @see Object#toString()
     */
    public String toString() {
        String s = "";
        // Predefined styles
        for (int i = 0; i < this.styles.length; i++)
            if (this.styles[i]) {
                if (s.length() > 0)
                    s += ",";
                s += styleAttributeName[i];
            }
        // Custom styles
        if (this.getOtherStyles() != null)
            for (int i = 0; i < this.getOtherStyles().length; i++) {
                if (i > 0)
                    s += ",";
                s += this.getOtherStyles()[i];
            }
        if (s.equals(""))
            return "";
        return "\"" + s + "\"";
    }
}
