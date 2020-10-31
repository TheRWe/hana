const path = require("path");
const CleanWebpackPlugin = require("clean-webpack-plugin");
const ExtractTextPlugin = require("extract-text-webpack-plugin");
const UglifyJsPlugin = require("uglifyjs-webpack-plugin");
const webpack = require("webpack");
const CopyPlugin = require("copy-webpack-plugin");

const targetPath = path.resolve("../target/classes/static");

// TODO: refactor config
// TODO: add support for service-worker

module.exports = function (env, argv) {
    const isProduction = argv.mode == "production";


    const cssAssetName = isProduction ? "/css/bundle.min.css" : "/css/bundle.css";
    const plugins = [
        new ExtractTextPlugin({
            filename: cssAssetName,
            allChunks: true
        }),
        new CopyPlugin({
            patterns: [{
                from: 'src/static',
                to: targetPath
            }]
        })
    ];

    if (isProduction) {
        plugins.push(
            new CleanWebpackPlugin(targetPath)
        );
    } else {
        plugins.push(
            new webpack.HotModuleReplacementPlugin(),
            new webpack.NamedModulesPlugin()
        );
    }

    return {
        mode: isProduction ? "production" : "development",
        entry: ["./src/index.tsx"],
        output: {
            filename: "js/" + (isProduction ? "bundle.min.js" : "bundle.js"),
            path: targetPath
        },
        devtool: isProduction ? "source-map" : "none",
        devServer: {
            historyApiFallback: true,
            contentBase: [targetPath, targetPath.substr(0, targetPath.length - "/static".length)],
            publicPath: targetPath,
            compress: true,
            port: 3000,
            open: true
        },
        module: {
            rules: [
                {
                    test: /\.json$/,
                    exclude: /node_modules/,
                    loader: 'json-loader',
                },
                {
                    test: /\.html$/i,
                    exclude: /node_modules/,
                    use: ['file-loader?name=[name].[ext]', 'extract-loader', 'html-loader'],
                },
                {
                    test: /\.jsx?$/,
                    exclude: /node_modules/,
                    include: /src/,
                    loader: "babel-loader",
                    query: {
                        presets: ['es2015', 'stage-2', 'react']
                    }
                },
                {
                    test: /\.tsx?$/,
                    loader: "ts-loader",
                    exclude: [/node_modules/]
                },
                {
                    test: /\.scss$/,
                    exclude: /node_modules/,
                    use: ["css-hot-loader"].concat(ExtractTextPlugin.extract({
                        use: [
                            {
                                loader: "css-loader",
                                options: {
                                    url: false,
                                    minimize: isProduction,
                                    sourceMap: isProduction
                                }
                            },
                            {
                                loader: "sass-loader",
                                options: {
                                    sourceMap: isProduction
                                }
                            }
                        ]
                    }))
                }
            ]
        },
        resolve: {
            extensions: [".ts", ".tsx", ".js", ".jsx", ".json", ".scss", ".html"]
        },
        plugins: plugins,
        optimization: {
            minimizer: [new UglifyJsPlugin({
                uglifyOptions: {
                    compress: isProduction,
                    mangle: true,
                    keep_fnames: isProduction,
                    output: {
                        beautify: !isProduction,
                        comments: false
                    }
                }
            })]
        }

    };
};