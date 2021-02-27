package io.github.jonzarate.carvandroidtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val coordinates =
            listOf(
                listOf<Double>(18.81799, 35.7445, 12.0),
                listOf<Double>(23.13299, 16.8974, 12.0),
                listOf<Double>(16.21079, 0.0, 12.0),
                listOf<Double>(4.51639, 12.8394, 12.0),
                listOf<Double>(1.0195, 30.0177, 12.0),
                listOf<Double>(0.0, 47.8785, 12.0),
                listOf<Double>(16.79069, 75.0814, 12.0),
                listOf<Double>(17.37789, 55.0006, 12.0),
                listOf<Double>(0.09226, 66.3364, 12.0),
                listOf<Double>(1.20363, 85.2964, 12.0),
                listOf<Double>(5.23729, 103.1604, 12.0),
                listOf<Double>(10.80269, 119.8994, 12.0),
                listOf<Double>(49.83219, 76.6024, 12.0),
                listOf<Double>(48.60009, 57.5435, 12.0),
                listOf<Double>(32.11859, 65.6744, 12.0),
                listOf<Double>(34.12719, 84.2464, 12.0),
                listOf<Double>(20.07639, 94.9624, 12.0),
                listOf<Double>(28.51799, 111.0354, 12.0),
                listOf<Double>(61.30659, 46.0354, 12.0),
                listOf<Double>(56.13399, 28.9682, 12.0),
                listOf<Double>(48.50349, 11.5261, 12.0),
                listOf<Double>(34.56289, 0.3548, 12.0),
                listOf<Double>(38.17069, 27.5453, 12.0),
                listOf<Double>(35.22639, 44.9827, 12.0),
                listOf<Double>(55.04799, 198.3864, 12.0),
                listOf<Double>(55.88789, 179.9024, 12.0),
                listOf<Double>(56.84219, 161.4354, 12.0),
                listOf<Double>(43.50699, 149.4534, 12.0),
                listOf<Double>(59.07229, 141.0914, 12.0),
                listOf<Double>(62.15939, 123.2974, 12.0),
                listOf<Double>(65.10429, 104.7454, 12.0),
                listOf<Double>(66.15519, 85.8874, 12.0),
                listOf<Double>(48.01899, 96.2824, 12.0),
                listOf<Double>(64.90409, 65.8474, 12.0),
                listOf<Double>(46.53939, 113.7714, 12.0),
                listOf<Double>(40.33179, 131.1734, 12.0),
                listOf<Double>(18.88199, 167.2574, 12.0),
                listOf<Double>(19.26569, 185.1634, 12.0),
                listOf<Double>(19.54539, 203.4754, 12.0),
                listOf<Double>(54.23549, 216.9704, 12.0),
                listOf<Double>(37.64889, 188.5244, 12.0),
                listOf<Double>(38.30579, 169.7164, 12.0),
                listOf<Double>(20.17889, 222.1694, 12.0),
                listOf<Double>(24.26149, 242.2284, 12.0),
                listOf<Double>(41.02829, 248.7884, 12.0),
                listOf<Double>(36.41349, 226.8844, 12.0),
                listOf<Double>(51.71179, 235.2194, 12.0),
                listOf<Double>(37.39319, 208.1334, 12.0),
                listOf<Double>(37.39319, 208.1334, 12.0)
            )


        findViewById<DynamicView>(R.id.dynamic_view).coordinates = coordinates
        findViewById<DynamicView>(R.id.dynamic_view2).coordinates = coordinates
        findViewById<DynamicView>(R.id.dynamic_view3).coordinates = coordinates
    }
}