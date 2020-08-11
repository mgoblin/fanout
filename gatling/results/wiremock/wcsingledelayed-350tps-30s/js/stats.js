var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "42000",
        "ok": "42000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "30004",
        "ok": "30004",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "41642",
        "ok": "41642",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "30769",
        "ok": "30769",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "1524",
        "ok": "1524",
        "ko": "-"
    },
    "percentiles1": {
        "total": "30085",
        "ok": "30085",
        "ko": "-"
    },
    "percentiles2": {
        "total": "30673",
        "ok": "30673",
        "ko": "-"
    },
    "percentiles3": {
        "total": "34469",
        "ok": "34469",
        "ko": "-"
    },
    "percentiles4": {
        "total": "37352",
        "ok": "37352",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 42000,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "278.146",
        "ok": "278.146",
        "ko": "-"
    }
},
contents: {
"req_accountswcsingl-896ac": {
        type: "REQUEST",
        name: "AccountsWCSingleDelayed",
path: "AccountsWCSingleDelayed",
pathFormatted: "req_accountswcsingl-896ac",
stats: {
    "name": "AccountsWCSingleDelayed",
    "numberOfRequests": {
        "total": "42000",
        "ok": "42000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "30004",
        "ok": "30004",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "41642",
        "ok": "41642",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "30769",
        "ok": "30769",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "1524",
        "ok": "1524",
        "ko": "-"
    },
    "percentiles1": {
        "total": "30085",
        "ok": "30085",
        "ko": "-"
    },
    "percentiles2": {
        "total": "30673",
        "ok": "30673",
        "ko": "-"
    },
    "percentiles3": {
        "total": "34469",
        "ok": "34469",
        "ko": "-"
    },
    "percentiles4": {
        "total": "37352",
        "ok": "37352",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 42000,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "278.146",
        "ok": "278.146",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
