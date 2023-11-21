package graphing.plotter;

import java.io.FileWriter;
import java.io.IOException;

public class PlotBuilder {
    public static void plot(FileWriter writer, TabulatedFunction func, String outputFilename) throws IOException {
        writer.write("import matplotlib.pyplot as plt\n\n" +
                        "fig = plt.subplot()\n" +
                        "x = [" + func.xString(", ")
                    );

        writer.write("]\n" +
                        "y = [" + func.yString(", ")
                    );

        writer.write("""
                        ]
                        fig.plot(list(x), list(y), linestyle="None",  marker=".", markersize=1)
                        fig.spines['left'].set_position('zero')
                        fig.spines['bottom'].set_position('zero')
                        fig.spines['right'].set_color('none')
                        fig.spines['top'].set_color('none')
                        fig.xaxis.set_ticks_position('bottom')
                        fig.yaxis.set_ticks_position('left')
                        """
                    );

        writer.write("fig.set_xlim([" + func.getxMin() + ", " + func.getxMax() + "])\n" +
                        "fig.set_ylim([" + func.getyMin() + ", " + func.getyMax() + "])\n" +
                        "plt.savefig(\"" + outputFilename + "\")\n" +
                        "plt.close()");
    }
}
