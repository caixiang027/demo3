seajs.timestamp="20140104";
home="/demo3";
staticUrl = '/demo3/static';
seajs.config({
	alias:{ "seajs-combo":"seajs/seajs-combo/1.0.1/seajs-combo",
			"seajs-log":"seajs/seajs-log/1.0.1/seajs-log",
			"seajs-style":"seajs/seajs-style/1.0.2/seajs-style",
			"seajs-debug":"seajs/seajs-debug/1.1.1/seajs-debug",
			jquery:"jquery/1.11.1/jquery.js",
			ajax:"plugins/ajax/1.0.0/ajax",
			test:"test.js"
		},
	base:(typeof staticUrl=="undefined"?"/static":staticUrl)+"/common",
	map:[[/(^(?!.*(config|jquery|seajs-log|seajs-style|seajs-combo|seajs-debug)\.(css|js)).*)$/i,"$1?t="+seajs.timestamp]],
	preload:["seajs-log","seajs-style","test",seajs.timestamp=="20140104"?"":"seajs-combo"],
	debug:seajs.timestamp=="20160127"?true:false,
	charset:"utf-8"
});