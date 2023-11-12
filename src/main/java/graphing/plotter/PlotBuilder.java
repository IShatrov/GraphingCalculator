package graphing.plotter;

import java.io.FileWriter;
import java.io.IOException;

public class PlotBuilder {
    public static void plot(FileWriter writer, TabulatedFunction func) throws IOException {
        prepareFile(writer, func);
    }

    private static void prepareFile(FileWriter writer, TabulatedFunction func) throws IOException {
        writer.write("import matplotlib.pyplot as plt\n\n" +
                        "fig = plt.subplot()\n" +
                        "x = ["
                    );

        func.writeX(writer, ", ");

        writer.write("]\n" +
                        "y = ["
                    );

        func.writeY(writer, ", ");

        writer.write("]\n" +
                        "fig.plot(list(x), list(y), linestyle=\"None\",  marker=\".\", markersize=1)\n" +
                        "fig.spines['left'].set_position('zero')\n" +
                        "fig.spines['bottom'].set_position('zero')\n" +
                        "fig.spines['right'].set_color('none')\n" +
                        "fig.spines['top'].set_color('none')\n" +
                        "fig.xaxis.set_ticks_position('bottom')\n" +
                        "fig.yaxis.set_ticks_position('left')\n" +
                        "fig.set_xlim([" + func.getxMin() + ", " + func.getxMax() + "])\n" +
                        "fig.set_ylim([" + func.getyMin() + ", " + func.getyMax() + "])\n" +
                        "plt.show()"
                    );
    }
}
