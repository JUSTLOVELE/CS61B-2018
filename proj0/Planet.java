
public class Planet {

    public double xxPos;

    public double yyPos;

    public double xxVel;// 速率

    public double yyVel;

    public double mass;

    public String imgFileName;

    private final static double G = 6.67e-11;

    public void draw() {
        // System.out.println(this.imgFileName);
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }

    /**
     * 更新加速度? ax = Fx/m ay = Fy/m
     * 
     * @param dt
     * @param fX //x分量的力
     * @param fY //y的分量的
     */
    public void update(double dt, double fX, double fY) {
        // F_(1,x) = F1 * dx / r
        // F_(1,y) = F1 * dy / r

        // F_(2,x) = F2 * dx / r
        // F_(2,y) = F2 * dy / r

        // F_net_x = F_(1,x) + F_(2,x)
        // F_net_y = F_(2,x) + F_(2,y)

        // a_net_x = F_net_x / m
        double ax = fX / this.mass;
        // a_net_y = F_net_y / m
        double ay = fY / this.mass;
        // v_new_x = v_old_x + dt*a_net_x
        this.xxVel = this.xxVel + dt * ax;
        // v_new_y = v_old_y + dt*a_net_y
        this.yyVel = this.yyVel + dt * ay;
        // p_new_x = p_old_x + dt*v_new_x
        this.xxPos = this.xxPos + dt * this.xxVel;
        // p_new_y = p_old_y + dt*v_new_y
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    /**
     * 计算行星群在y方向的净力
     * 
     * @param allPlanets
     * @return
     */
    public double calcNetForceExertedByY(Planet[] allPlanets) {

        double sum = 0.0;

        if (allPlanets == null || allPlanets.length <= 1) {
            return sum;
        }

        for (Planet p : allPlanets) {

            if (p.equals(this)) {
                continue;
            }

            sum += this.calcForceExertedByY(p);
        }

        return sum;
    }

    /**
     * 计算行星群在x方向的净力
     * 
     * @param allPlanets
     * @return
     */
    public double calcNetForceExertedByX(Planet[] allPlanets) {

        double sum = 0.0;

        if (allPlanets == null || allPlanets.length <= 1) {
            return sum;
        }

        for (Planet p : allPlanets) {

            if (p.equals(this)) {
                continue;
            }

            sum += this.calcForceExertedByX(p);
        }

        return sum;
    }

    /**
     * 计算y的分量
     * 
     * @param p
     * @return
     */
    public double calcForceExertedByY(Planet p) {

        double F = calcForceExertedBy(p);
        double r = calcDistance(p);
        double dy = this.yyPos - p.yyPos;

        return (F * dy) / r;
    }

    /**
     * 计算F在x轴上的分量
     * 
     * @param p
     * @return
     */
    public double calcForceExertedByX(Planet p) {

        double F = calcForceExertedBy(p);
        double r = calcDistance(p);
        double dx = this.xxPos - p.xxPos;

        return (F * dx) / r;
    }

    /**
     * 计算总力
     * 
     * @param p
     * @return
     */
    public double calcForceExertedBy(Planet p) {

        double r2 = (this.xxPos - p.xxPos) * (this.xxPos - p.xxPos) + (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos);
        double F = (G * this.mass * p.mass) / r2;

        return F;
    }

    /**
     * 计算两个球体的距离
     * 
     * @param p
     * @return
     */
    public double calcDistance(Planet p) {

        double distance = (this.xxPos - p.xxPos) * (this.xxPos - p.xxPos)
                + (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos);
        return Math.sqrt(distance);
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

}
