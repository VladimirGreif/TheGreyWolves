package com.jsoft.game.thegreywolves.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.media.j3d.Alpha;
import javax.media.j3d.AmbientLight;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.ImageComponent2D;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JPanel;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

import com.jsoft.game.thegreywolves.general.AUnit;
import com.jsoft.game.thegreywolves.general.UnitConfiguration.TYPE;
import com.sun.j3d.loaders.IncorrectFormatException;
import com.sun.j3d.loaders.ParsingErrorException;
import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class Panel3D extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SimpleUniverse univ = null;
    private BranchGroup scene = null;
    private BranchGroup objRoot = null;
    private AUnit unit;
    private Scene cargo; 
    private Scene destroyer;
    private Scene submarine;
    private Scene temp;

	public Panel3D(){
		super();
		
        setPreferredSize(new Dimension(400, 300));
    	// Create Canvas3D and SimpleUniverse; add canvas to drawing panel
    	Canvas3D c = createUniverse();
    	add(c, java.awt.BorderLayout.CENTER);
    	loadObjects();
    	// Create the content branch and add it to the universe
    	scene = createSceneGraph();
    	univ.addBranchGraph(scene);

	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);  // paint background
//		setBackground(Color.BLUE);
		System.out.println("Paint");
		objRoot.detach();
//		objRoot.removeAllChildren();
    	scene = createSceneGraph();
    	univ.addBranchGraph(scene);
	}
	
	private void loadObjects(){
		FileReader reader = null;
		try{

			String path = "D:\\SpringProjects\\TheGreyWolves\\FishingBoat\\msmunchen.obj";
			if(unit!= null){
				if(unit.getType()==TYPE.DESTROER){
					path = "D:\\SpringProjects\\TheGreyWolves\\WICK40\\Wick40.obj";
					
				}else if(unit.getType()==TYPE.SUBMARINE){
					path = "D:\\SpringProjects\\TheGreyWolves\\U48\\U48.obj";
				}
			}
			
			
			File file = new File(path);
			reader = new FileReader(file);
		   	ObjectFile f = new ObjectFile ();
			f.setFlags (ObjectFile.RESIZE | ObjectFile.TRIANGULATE | ObjectFile.STRIPIFY);
			temp = f.load (reader);
			reader.close();
		}catch(Exception e){
			System.out.println("Something is not working");
			e.printStackTrace();
		}finally{
			if(reader!=null)
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

    public BranchGroup createSceneGraph() {
	// Create the root of the branch graph
	
    objRoot = new BranchGroup();
    objRoot.setCapability(BranchGroup.ALLOW_DETACH);
	// Create the TransformGroup node and initialize it to the
	// identity. Enable the TRANSFORM_WRITE capability so that
	// our behavior code can modify it at run time. Add it to
	// the root of the subgraph.
	TransformGroup objTrans = new TransformGroup();
	objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

	objRoot.addChild(objTrans);
	loadObjects();
	objTrans.addChild(temp.getSceneGroup ());
	
//	objTrans.addChild(new ColorCube(0.4));
	// Create a red light that shines for 1000m from the origin

	   Color3f light1Color = new Color3f(1.f, 1.f, 1.f);

	   BoundingSphere bounds0 =

	   new BoundingSphere(new Point3d(0.0,0.0,0.0), 1000.0);

	   Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);

	   DirectionalLight light1

	      = new DirectionalLight(light1Color, light1Direction);

	   light1.setInfluencingBounds(bounds0);
	   objTrans.addChild(light1);
	   
	   AmbientLight light2 = new AmbientLight(true, light1Color);
	   light2.setInfluencingBounds(bounds0);
	   objTrans.addChild(light2);
	   
	// Create a new Behavior object that will perform the
	// desired operation on the specified transform and add
	// it into the scene graph.
	Transform3D yAxis = new Transform3D();
	Alpha rotationAlpha = new Alpha(-1, 10000);

	RotationInterpolator rotator =
	    new RotationInterpolator(rotationAlpha, objTrans, yAxis,
				     0.0f, (float) Math.PI*2.0f);
	BoundingSphere bounds =
	    new BoundingSphere(new Point3d(0.0,0.0,0.0), 1000.0);
	rotator.setSchedulingBounds(bounds);
	objRoot.addChild(rotator);
	//Background
//	Background background = new Background(new Color3f(Color.BLUE));
//	BoundingSphere sphere = new BoundingSphere(new Point3d(0,0,0), 100000);
//	background.setApplicationBounds(sphere);
//	objRoot.addChild(background);
	

	TextureLoader myLoader = new TextureLoader( "BackGround.jpg", this );
	ImageComponent2D myImage = myLoader.getImage( );
	Background myBack = new Background( );
	myBack.setImage( myImage );
	BoundingSphere myBounds = new BoundingSphere(
			new Point3d(0,0,0), 10000.0 );
	myBack.setApplicationBounds( myBounds );
	objRoot.addChild(myBack);
	
        // Have Java 3D perform optimizations on this scene graph.
        objRoot.compile();

	return objRoot;
    }

    private Canvas3D createUniverse() {
	// Get the preferred graphics configuration for the default screen
	GraphicsConfiguration config =
	    SimpleUniverse.getPreferredConfiguration();

	// Create a Canvas3D using the preferred configuration
	Canvas3D c = new Canvas3D(config);
	c.setSize(400, 300);
	c.setBackground(Color.BLUE);

	// Create simple universe with view branch
	univ = new SimpleUniverse(c);

	// This will move the ViewPlatform back a bit so the
	// objects in the scene can be viewed.
	univ.getViewingPlatform().setNominalViewingTransform();

	// Ensure at least 5 msec per frame (i.e., < 200Hz)
	univ.getViewer().getView().setMinimumFrameCycleTime(5);

	return c;
    }

	public AUnit getUnit() {
		return unit;
	}

	public void setUnit(AUnit unit) {
		this.unit = unit;
	}

}
