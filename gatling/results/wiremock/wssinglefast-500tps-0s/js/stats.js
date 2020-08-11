var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "60000",
        "ok": "60000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "2",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1802",
        "ok": "1802",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "34",
        "ok": "34",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "141",
        "ok": "141",
        "ko": "-"
    },
    "percentiles1": {
        "total": "7",
        "ok": "7",
        "ko": "-"
    },
    "percentiles2": {
        "total": "12",
        "ok": "12",
        "ko": "-"
    },
    "percentiles3": {
        "total": "31",
        "ok": "31",
        "ko": "-"
    },
    "percentiles4": {
        "total": "777",
        "ok": "777",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 59454,
    "percentage": 99
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 380,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 166,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "500",
        "ok": "500",
        "ko": "-"
    }
},
contents: {
"req_accountswssingl-bf335": {
        type: "REQUEST",
        name: "AccountsWSSingleFast",
path: "AccountsWSSingleFast",
pathFormatted: "req_accountswssingl-bf335",
stats: {
    "name": "AccountsWSSingleFast",
    "numberOfRequests": {
        "total": "60000",
        "ok": "60000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "2",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1802",
        "ok": "1802",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "34",
        "ok": "34",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "141",
        "ok": "141",
        "ko": "-"
    },
    "percentiles1": {
        "total": "7",
        "ok": "7",
        "ko": "-"
    },
    "percentiles2": {
        "total": "12",
        "ok": "12",
        "ko": "-"
    },
    "percentiles3": {
        "total": "31",
        "ok": "31",
        "ko": "-"
    },
    "percentiles4": {
        "total": "777",
        "ok": "777",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 59454,
    "percentage": 99
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 380,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 166,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "500",
        "ok": "500",
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
