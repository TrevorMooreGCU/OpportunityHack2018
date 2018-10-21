


<input type="hidden" id="columns" value="${columns}">
	
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    
    <script type="text/javascript">
        google.charts.load('current', { 'packages': ['bar'] });
        google.charts.load('current', { 'packages': ['corechart'] });
        google.charts.load('current', {
            'packages': ['geochart'],
            'mapsApiKey': 'AIzaSyD-9tSrke72PouQMnMX-a7eZSW0jkFMBWY'
        });
        google.charts.setOnLoadCallback(drawStuff);

        function loadJSON() {

            $.ajax({
                type: "POST",
                url: "http://localhost:8080/Hackathon/analyticsservice/analyze",
                data: { table: "Schools" },
                success: function (json) {
                	var data = $.parseJSON(json);
                	for (var x in data) {
                		$("#x-axis").append('<option value="' + data[x].id + '">' + data[x].columnName + '</option>');
                		$("#y-axis").append('<option value="' + data[x].id + '">' + data[x].columnName + ' (Occurences)</option>');
                		//if (data[x].columnType == "number")
                		//	$("#y-axis").append('<option value="' + data[x].id + '">' + data[x].columnName + ' (Number)</option>');
                	}
                },
                error: function() {
                	alert("error");
                },
                dataType: 'text'
            });

            return new google.visualization.arrayToDataTable([
                ["Breed", "Adopted Dogs"],
                ["doggo", 23],
                ["woofer", 58],
                ["chubber", 3],
                ["sneck", 12],
                ["sub-Woofer", 38],
                ["pupper", 27]
            ]);
        }
        
        
        function drawStuff(Wide, Hide, chart) {
            if (Wide == undefined) {
                Wide = 530;
                Hide = 400;
            }

            var data = loadJSON();

            var country_data = new google.visualization.arrayToDataTable([
                ["Countries", "Adopted Dogs"],
                ["US", 23],
                ["Mexico", 58],
                ["Canada", 3],
                ["RU", 12],
                ["Brazil", 38],
                ["South Africa", 27]
            ]);

            var options = {
                width: Wide,
                height: Hide,
                legend: { position: 'none' },
                bars: 'vertical',
                axes: {
                    y: {
                        0: { side: 'left', label: 'y' }
                    },
                    x: {
                        0: { side: 'bottom', label: 'x' }
                    }
                },
                backgroundColor: "rgb(245, 245, 245)",
            };

            switch (chart) {
                case "bar_chart":
                    var chart_bar = new google.charts.Bar(document.getElementById('bar_chart'));
                    chart_bar.draw(data, google.charts.Bar.convertOptions(options));
                    break;
                case "pie_chart":
                    options.legend = { position: 'right' };
                    var Pie_chart = new google.visualization.PieChart(document.getElementById('pie_chart'));
                    Pie_chart.draw(data, options);
                    break;
                case "curve_chart":
                    var Scatter_chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
                    Scatter_chart.draw(data, options);
                    break;
                case "regions_chart":
                    var Geo_chart = new google.visualization.GeoChart(document.getElementById('regions_chart'));
                    Geo_chart.draw(country_data, options);
                    break;
                default:
                    var chart_bar = new google.charts.Bar(document.getElementById('bar_chart'));
                    chart_bar.draw(data, google.charts.Bar.convertOptions(options));

                    var Scatter_chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
                    Scatter_chart.draw(data, options);

                    var Geo_chart = new google.visualization.GeoChart(document.getElementById('regions_chart'));
                    Geo_chart.draw(country_data, options);

                    options.legend = { position: 'right' };
                    var Pie_chart = new google.visualization.PieChart(document.getElementById('pie_chart'));
                    Pie_chart.draw(data, options);
            }
        }
    </script>

<body class="container">
    <h1 style="color: #000000;">Data Analysis</h1>

    <form onsubmit="determineChart(event)">
        <div class="col-lg-4">
            <select id="x-axis" class="form-control">
            </select>
        </div>
        <div class="col-lg-4">
            <select id="y-axis" class="form-control">
            </select>
        </div>
        <div class="col-offset-lg-2 col-lg-2">
            <input class="form-control btn-primary" type="submit">
        </div>
        <br />
    </form>

    <h2 id="analysis_header" style="display: block; color: #000000;">Breed vs. Population</h2>
    <div class="charts" style="margin-bottom: 900px;">
        <div style="display: block;">
            <button class="btn btn-info" onclick="ToggleChart(this)">Bar Chart</button>
            <div id="bar_chart"></div>
        </div>
        <div style="display: block;">
            <button class="btn btn-info" onclick="ToggleChart(this)">Pie Chart</button>
            <div id="pie_chart"></div>
        </div>
        <div style="display: block;">
            <button class="btn btn-info" onclick="ToggleChart(this)">Curve Chart</button>
            <div id="curve_chart"></div>
        </div>
        <div style="display: block;">
            <button class="btn btn-info" onclick="ToggleChart(this)">Regions Graph</button>
            <div id="regions_chart"></div>
        </div>
    </div>

    <script>

        function determineChartByStr(str) {
            if (str == "Xint") {
                document.getElementById("analysis_header").style.display = "block";
                document.getElementById("bar_chart").parentElement.style.display = "block";
                document.getElementById("pie_chart").parentElement.style.display = "block";
                document.getElementById("curve_chart").parentElement.style.display = "none";
                document.getElementById("regions_chart").parentElement.style.display = "none";
            }
            else if (str == "Xstring") {
                document.getElementById("analysis_header").style.display = "block";
                document.getElementById("bar_chart").parentElement.style.display = "none";
                document.getElementById("pie_chart").parentElement.style.display = "block";
                document.getElementById("curve_chart").parentElement.style.display = "block";
                document.getElementById("regions_chart").parentElement.style.display = "none";
            }
            else if (str == "Xlocation") {
                document.getElementById("analysis_header").style.display = "block";
                document.getElementById("bar_chart").parentElement.style.display = "none";
                document.getElementById("pie_chart").parentElement.style.display = "none";
                document.getElementById("curve_chart").parentElement.style.display = "none";
                document.getElementById("regions_chart").parentElement.style.display = "block";
            }
            else if (str == "Xall") {
                document.getElementById("analysis_header").style.display = "block";
                document.getElementById("bar_chart").parentElement.style.display = "block";
                document.getElementById("pie_chart").parentElement.style.display = "block";
                document.getElementById("curve_chart").parentElement.style.display = "block";
                document.getElementById("regions_chart").parentElement.style.display = "block";
            }
            else {
                document.getElementById("analysis_header").style.display = "block";
                document.getElementById("bar_chart").parentElement.style.display = "block";
                document.getElementById("pie_chart").parentElement.style.display = "block";
                document.getElementById("curve_chart").parentElement.style.display = "block";
                document.getElementById("regions_chart").parentElement.style.display = "block";
            }
        }

            
       function determineChart(event) {
                $.ajax({
                    type: "POST",
                    url: "http://localhost:8080/Hackathon/analyticsservice/analyzeData",
                    data: {
                    	table: "Schools",
                    	col1: $("#x-axis").val()
                    	//col2: $("#y-axis").val()
                    	},
                    success: function (json) {
                    	var data = $.parseJSON(json);
                    	alert(json);
                    	for (var x in data) {
                    		$("#x-axis").append('<option value="' + data[x].id + '">' + data[x].columnName + '</option>');
                    		$("#y-axis").append('<option value="' + data[x].id + '">' + data[x].columnName + ' (Occurences)</option>');
                    		//if (data[x].columnType == "number")
                    		//	$("#y-axis").append('<option value="N' + data[x].id + '">' + data[x].columnName + ' (Number)</option>');
                    	}
                    },
                    error: function() {
                    	alert("error");
                    },
                    dataType: 'text'
                });
        	
            var x = document.getElementById("x-axis");
            var elem = x.options[x.selectedIndex].value;

            event.preventDefault();

            determineChartByStr(elem);

            return false;
        }

        function ToggleChart(chart) {
            var arr = ["bar_chart", "curve_chart", "pie_chart", "reions_chart"];
            if ($(chart.parentElement).width() > 560) {
                $(chart.parentElement).css({ "position": "relative", "z-index": "0" })
                $(chart.parentElement).animate({
                    height: '470px',
                    width: '560px'
                });
                drawStuff();

                var x = document.getElementById("x-axis");
                var elem = x.options[x.selectedIndex].value;
                determineChartByStr(elem);
            }
            else {
                $(chart.parentElement).css({"position": "absolute", "z-index": "1"})
                $(chart.parentElement).animate({
                    height: 780,
                    width: $(".charts").width()
                });
                for (var x in arr) {
                    if (arr[x] != $(chart).next().attr('id'))
                        $("#"+arr[x]).parent().css("display", "none");
                }
                drawStuff($(".charts").width() - 30, 700, $(chart).next().attr('id'));
                
            }
        }

    </script>

    
    
    
    