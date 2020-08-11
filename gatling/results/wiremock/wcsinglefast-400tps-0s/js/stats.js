var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "48000",
        "ok": "48000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "4",
        "ok": "4",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "3237",
        "ok": "3237",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "197",
        "ok": "197",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "493",
        "ok": "493",
        "ko": "-"
    },
    "percentiles1": {
        "total": "10",
        "ok": "10",
        "ko": "-"
    },
    "percentiles2": {
        "total": "21",
        "ok": "21",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1490",
        "ok": "1490",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2193",
        "ok": "2193",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 42838,
    "percentage": 89
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1562,
    "percentage": 3
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 3600,
    "percentage": 8
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "396.694",
        "ok": "396.694",
        "ko": "-"
    }
},
contents: {
"req_accountswcsingl-b0891": {
        type: "REQUEST",
        name: "AccountsWCSingleFast",
path: "AccountsWCSingleFast",
pathFormatted: "req_accountswcsingl-b0891",
stats: {
    "name": "AccountsWCSingleFast",
    "numberOfRequests": {
        "total": "48000",
        "ok": "48000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "4",
        "ok": "4",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "3237",
        "ok": "3237",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "197",
        "ok": "197",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "493",
        "ok": "493",
        "ko": "-"
    },
    "percentiles1": {
        "total": "10",
        "ok": "10",
        "ko": "-"
    },
    "percentiles2": {
        "total": "21",
        "ok": "21",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1490",
        "ok": "1490",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2193",
        "ok": "2193",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 42838,
    "percentage": 89
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1562,
    "percentage": 3
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 3600,
    "percentage": 8
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "396.694",
        "ok": "396.694",
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
