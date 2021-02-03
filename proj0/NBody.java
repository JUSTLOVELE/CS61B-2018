import java.util.ArrayList;
import java.util.List;

public class NBody {

    public static Planet[] readPlanets(String path) {

        if (path == null || "".equals(path))
            return null;

        In in = new In(path);
        int planetsNum = in.readInt();
        double radius = in.readDouble();
        List<Planet> planets = new ArrayList<Planet>();

        while (!in.isEmpty()) {
            // System.out.println(in.readString());
            Planet p = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(),
                    in.readString());
            planets.add(p);

            if (planets.size() == planetsNum) {
                break;
            }
        }

        Planet[] ps = new Planet[planets.size()];

        for (int i = 0; i < planets.size(); i++) {
            ps[i] = planets.get(i);
        }

        return ps;
    }

    /**
     * 读半径,其实就是读取第二个数据
     * 
     * @param planetsTxtPath
     * @return
     */
    public static double readRadius(String planetsTxtPath) {

        if (planetsTxtPath == null || "".equals(planetsTxtPath))
            return 0.0;

        In in = new In(planetsTxtPath);
        int planetsNum = in.readInt();
        double radius = in.readDouble();
        in.close();

        return radius;
    }

    public static void main(String[] args) {

        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        String imageToDraw = "images/starfield.jpg";
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);
        /* Clears the drawing window. */
        StdDraw.clear();
        double time = 0;

        while (time <= T) {

            double[] xforce = new double[planets.length];
            double[] yforce = new double[planets.length];

            for (int i = 0; i < planets.length; i++) {

                xforce[i] = planets[i].calcNetForceExertedByX(planets);
                yforce[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xforce[i], yforce[i]);
            }

            StdDraw.picture(0, 0, imageToDraw);
            for (Planet p : planets) {
                p.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", planets[i].xxPos, planets[i].yyPos,
                    planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
