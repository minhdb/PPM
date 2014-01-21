<h4> PPM image format render-reader </h4>
<p> This is a project from my first course in computer science from University of Wisconsin </p>

PPM reader classes:
<ul>
	<li> In class: In.java </li>
	<li> PPM_Viewer main class: PPM_Viewer.java </li>
</ul>
<br>
PPM image rendering classes:
<ul>
	<li><strong>Main class: PortablePixelMapperEC.java</strong></li>
	<li>SVGEC.java</li>
	<li>PPMEC.java</li>
	<li>InvalidSVGFileFormatExceptionEC.java</li>
</ul>
<br>
Shapes classes:
<ul>
	<li>ShapesEC.java - All other classes are inherited from this class.
		</li>
	<li>RingEC.java</li>
	<li>SquareEC.java</li>
	<li>CircleEC.java</li>
	<li>RectangleEC.java</li>
	<li>OvalEC.java</li>
	<li>equilateral_triangleEC.java</li>
	<li>CcircleEC.java - (circumvented circle) incompleted</li>
</ul>

<p> To run the rendering program, basically type in the commandline:</p>
<code>
javac *java //Compile the program<br>
java PortablePixelMappers [nameOfShapesTextFile] [width] [height] [nameOfOutPutFile]
</code>	
<br>
<p> To run the viewer program: </p>
<code>
java PPMViewerEC [nameOfPPMImage]
</code>
<br>
<h3> Shapes parameters </h3>
Circle<br> 
Ring<br>
Square<br>
Oval<br>
Rectangle<br>
equilateral_triangle<br>
Ccircle<br>
Ring<br>
*** <strong><span style = "font-size: 21"> COMING SOON </span></strong>
