/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * aapt tool from the resource data it found.  It
 * should not be modified by hand.
 */

package be.ac.vub.nrt;

public final class R {
    public static final class attr {
        /** <p>Must be a color value, in the form of "<code>#<i>rgb</i></code>", "<code>#<i>argb</i></code>",
"<code>#<i>rrggbb</i></code>", or "<code>#<i>aarrggbb</i></code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static final int lineAxisColor=0x7f010001;
        /** <p>Must be a color value, in the form of "<code>#<i>rgb</i></code>", "<code>#<i>argb</i></code>",
"<code>#<i>rrggbb</i></code>", or "<code>#<i>aarrggbb</i></code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static final int lineStrokeColor=0x7f010000;
        /** <p>Must be a dimension value, which is a floating point number appended with a unit such as "<code>14.5sp</code>".
Available units are: px (pixels), dp (density-independent pixels), sp (scaled pixels based on preferred font size),
in (inches), mm (millimeters).
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static final int lineStrokeSpacing=0x7f010003;
        /** <p>Must be a dimension value, which is a floating point number appended with a unit such as "<code>14.5sp</code>".
Available units are: px (pixels), dp (density-independent pixels), sp (scaled pixels based on preferred font size),
in (inches), mm (millimeters).
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static final int lineStrokeWidth=0x7f010002;
        /** <p>Must be a boolean value, either "<code>true</code>" or "<code>false</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static final int lineUseDip=0x7f010004;
    }
    public static final class drawable {
        public static final int bbsc1=0x7f020000;
        public static final int bbsc10=0x7f020001;
        public static final int bbsc2=0x7f020002;
        public static final int bbsc3=0x7f020003;
        public static final int bbsc4=0x7f020004;
        public static final int bbsc5=0x7f020005;
        public static final int bbsc6=0x7f020006;
        public static final int bbsc7=0x7f020007;
        public static final int bbsc8=0x7f020008;
        public static final int bbsc9=0x7f020009;
        public static final int ic_launcher=0x7f02000a;
        public static final int icon=0x7f02000b;
    }
    public static final class id {
        public static final int action_day=0x7f070008;
        public static final int action_range=0x7f070009;
        public static final int date=0x7f070004;
        public static final int endDate=0x7f070007;
        public static final int graph=0x7f070005;
        public static final int imgBear=0x7f070000;
        public static final int movementVal=0x7f070002;
        public static final int noiseVal=0x7f070003;
        public static final int restVal=0x7f070001;
        public static final int startDate=0x7f070006;
    }
    public static final class layout {
        public static final int datafragment=0x7f030000;
        public static final int day=0x7f030001;
        public static final int range=0x7f030002;
    }
    public static final class menu {
        public static final int actionbar_actions=0x7f060000;
    }
    public static final class string {
        public static final int app_name=0x7f040000;
        public static final int bearDescription=0x7f040008;
        public static final int day=0x7f040003;
        public static final int fill_date=0x7f040001;
        public static final int movement=0x7f040005;
        public static final int noise=0x7f040006;
        public static final int number=0x7f040007;
        public static final int quality=0x7f040009;
        public static final int range=0x7f040002;
        public static final int rest=0x7f040004;
    }
    public static final class style {
        /** 
        Base application theme, dependent on API level. This theme is replaced
        by AppBaseTheme from res/values-vXX/styles.xml on newer devices.
    

            Theme customizations available in newer API levels can go in
            res/values-vXX/styles.xml, while customizations related to
            backward-compatibility can go here.
        

        Base application theme for API 11+. This theme completely replaces
        AppBaseTheme from res/values/styles.xml on API 11+ devices.
    
 API 11 theme customizations can go here. 

        Base application theme for API 14+. This theme completely replaces
        AppBaseTheme from BOTH res/values/styles.xml and
        res/values-v11/styles.xml on API 14+ devices.
    
 API 14 theme customizations can go here. 
         */
        public static final int AppBaseTheme=0x7f050000;
        /**  Application theme. 
 All customizations that are NOT specific to a particular API-level can go here. 
         */
        public static final int AppTheme=0x7f050001;
    }
    public static final class styleable {
        /** Attributes that can be used with a LineGraph.
           <p>Includes the following attributes:</p>
           <table>
           <colgroup align="left" />
           <colgroup align="left" />
           <tr><th>Attribute</th><th>Description</th></tr>
           <tr><td><code>{@link #LineGraph_lineAxisColor be.ac.vub.nrt:lineAxisColor}</code></td><td></td></tr>
           <tr><td><code>{@link #LineGraph_lineStrokeColor be.ac.vub.nrt:lineStrokeColor}</code></td><td></td></tr>
           <tr><td><code>{@link #LineGraph_lineStrokeSpacing be.ac.vub.nrt:lineStrokeSpacing}</code></td><td></td></tr>
           <tr><td><code>{@link #LineGraph_lineStrokeWidth be.ac.vub.nrt:lineStrokeWidth}</code></td><td></td></tr>
           <tr><td><code>{@link #LineGraph_lineUseDip be.ac.vub.nrt:lineUseDip}</code></td><td></td></tr>
           </table>
           @see #LineGraph_lineAxisColor
           @see #LineGraph_lineStrokeColor
           @see #LineGraph_lineStrokeSpacing
           @see #LineGraph_lineStrokeWidth
           @see #LineGraph_lineUseDip
         */
        public static final int[] LineGraph = {
            0x7f010000, 0x7f010001, 0x7f010002, 0x7f010003,
            0x7f010004
        };
        /**
          <p>This symbol is the offset where the {@link be.ac.vub.nrt.R.attr#lineAxisColor}
          attribute's value can be found in the {@link #LineGraph} array.


          <p>Must be a color value, in the form of "<code>#<i>rgb</i></code>", "<code>#<i>argb</i></code>",
"<code>#<i>rrggbb</i></code>", or "<code>#<i>aarrggbb</i></code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          @attr name be.ac.vub.nrt:lineAxisColor
        */
        public static final int LineGraph_lineAxisColor = 1;
        /**
          <p>This symbol is the offset where the {@link be.ac.vub.nrt.R.attr#lineStrokeColor}
          attribute's value can be found in the {@link #LineGraph} array.


          <p>Must be a color value, in the form of "<code>#<i>rgb</i></code>", "<code>#<i>argb</i></code>",
"<code>#<i>rrggbb</i></code>", or "<code>#<i>aarrggbb</i></code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          @attr name be.ac.vub.nrt:lineStrokeColor
        */
        public static final int LineGraph_lineStrokeColor = 0;
        /**
          <p>This symbol is the offset where the {@link be.ac.vub.nrt.R.attr#lineStrokeSpacing}
          attribute's value can be found in the {@link #LineGraph} array.


          <p>Must be a dimension value, which is a floating point number appended with a unit such as "<code>14.5sp</code>".
Available units are: px (pixels), dp (density-independent pixels), sp (scaled pixels based on preferred font size),
in (inches), mm (millimeters).
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          @attr name be.ac.vub.nrt:lineStrokeSpacing
        */
        public static final int LineGraph_lineStrokeSpacing = 3;
        /**
          <p>This symbol is the offset where the {@link be.ac.vub.nrt.R.attr#lineStrokeWidth}
          attribute's value can be found in the {@link #LineGraph} array.


          <p>Must be a dimension value, which is a floating point number appended with a unit such as "<code>14.5sp</code>".
Available units are: px (pixels), dp (density-independent pixels), sp (scaled pixels based on preferred font size),
in (inches), mm (millimeters).
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          @attr name be.ac.vub.nrt:lineStrokeWidth
        */
        public static final int LineGraph_lineStrokeWidth = 2;
        /**
          <p>This symbol is the offset where the {@link be.ac.vub.nrt.R.attr#lineUseDip}
          attribute's value can be found in the {@link #LineGraph} array.


          <p>Must be a boolean value, either "<code>true</code>" or "<code>false</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          @attr name be.ac.vub.nrt:lineUseDip
        */
        public static final int LineGraph_lineUseDip = 4;
    };
}
