**This project implements the logic of drawing a graph using the Bezier curve.**

---

When you click on any circle point, a toast with the `X` and `Y` coordinates is displayed.

---

_**Settings that can be specified in `xml` file:**_

_Attrs for grid:_
- grid_line_rows
- grid_line_column
- grid_line_width
- grid_line_color


_Attrs for curve:_
- line_color
- line_width


_Attrs for circle:_
- circle_color
- circle_radius


example:

```
<com.example.customviewsapp.customview.LineView
   android:id="@+id/lv"
   android:layout_width="match_parent"
   android:layout_height="match_parent"
   android:layout_margin="10dp"

   custom:circle_color="@color/green"
   custom:circle_radius="13"

   custom:grid_line_color="@color/grey"
   custom:grid_line_column="15"
   custom:grid_line_rows="15"
   custom:grid_line_width="1"

   custom:line_color="@color/red"
   custom:line_width="10" 
/>
```


---

![Chart example](/app/src/main/assets/1.jpg)