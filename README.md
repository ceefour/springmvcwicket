springmvcwicket
===============

WicketFilter + Spring MVC DispatcherServlet sharing the same URL pattern

## Wicket & Atmosphere Note

Note that Starter project is moving to Spring Boot + Spring MVC (public-facing) +
Mobile Angular UI (mobile + web client) + native WebSocket + Undertow.

Native WebSocket (i.e. Spring WebSocket) is an alternative to Atmosphere,
although Atmosphere probably will support Undertow in time.

Undertow is faster for my simplistic benchmark.

Tomcat 8.0:

    > ab -n10000 -c100 http://localhost:8080/
    This is ApacheBench, Version 2.3 <$Revision: 1528965 $>
    Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
    Licensed to The Apache Software Foundation, http://www.apache.org/

    Benchmarking localhost (be patient)
    Completed 1000 requests
    Completed 2000 requests
    Completed 3000 requests
    Completed 4000 requests
    Completed 5000 requests
    Completed 6000 requests
    Completed 7000 requests
    Completed 8000 requests
    Completed 9000 requests
    Completed 10000 requests
    Finished 10000 requests


    Server Software:        Apache-Coyote/1.1
    Server Hostname:        localhost
    Server Port:            8080

    Document Path:          /
    Document Length:        207 bytes

    Concurrency Level:      100
    Time taken for tests:   3.042 seconds
    Complete requests:      10000
    Failed requests:        0
    Total transferred:      4410000 bytes
    HTML transferred:       2070000 bytes
    Requests per second:    3287.76 [#/sec] (mean)
    Time per request:       30.416 [ms] (mean)
    Time per request:       0.304 [ms] (mean, across all concurrent requests)
    Transfer rate:          1415.92 [Kbytes/sec] received

    Connection Times (ms)
                  min  mean[+/-sd] median   max
    Connect:        0    0   0.3      0       3
    Processing:     1   30  32.4     22     414
    Waiting:        0   30  32.4     22     414
    Total:          1   30  32.4     22     414

    Percentage of the requests served within a certain time (ms)
      50%     22
      66%     31
      75%     37
      80%     42
      90%     59
      95%     79
      98%    117
      99%    198
     100%    414 (longest request)

Undertow 1.1.1:

    > ab -n10000 -c100 http://localhost:8080/
    This is ApacheBench, Version 2.3 <$Revision: 1528965 $>
    Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
    Licensed to The Apache Software Foundation, http://www.apache.org/

    Benchmarking localhost (be patient)
    Completed 1000 requests
    Completed 2000 requests
    Completed 3000 requests
    Completed 4000 requests
    Completed 5000 requests
    Completed 6000 requests
    Completed 7000 requests
    Completed 8000 requests
    Completed 9000 requests
    Completed 10000 requests
    Finished 10000 requests


    Server Software:
    Server Hostname:        localhost
    Server Port:            8080

    Document Path:          /
    Document Length:        207 bytes

    Concurrency Level:      100
    Time taken for tests:   0.664 seconds
    Complete requests:      10000
    Failed requests:        0
    Total transferred:      4140000 bytes
    HTML transferred:       2070000 bytes
    Requests per second:    15058.45 [#/sec] (mean)
    Time per request:       6.641 [ms] (mean)
    Time per request:       0.066 [ms] (mean, across all concurrent requests)
    Transfer rate:          6088.08 [Kbytes/sec] received

    Connection Times (ms)
                  min  mean[+/-sd] median   max
    Connect:        0    0   0.3      0       4
    Processing:     1    3   5.1      3     207
    Waiting:        1    3   5.1      3     207
    Total:          1    4   5.1      3     207

    Percentage of the requests served within a certain time (ms)
      50%      3
      66%      4
      75%      4
      80%      4
      90%      4
      95%      5
      98%      6
      99%      8
     100%    207 (longest request)
