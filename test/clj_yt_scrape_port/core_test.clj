(ns clj-yt-scrape-port.core-test
  (:require [clojure.test :refer :all]
            [clj-yt-scrape-port.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))



(def sample-search-list-response
  {:cached nil,
   :request-time 283,
   :repeatable? false,
   :protocol-version {:name "HTTP", :major 1, :minor 1},
   :streaming? true,
   :http-client "does not matter",
   :chunked? true,
   :reason-phrase "OK",
   :headers {"Server" "scaffolding on HTTPServer2",
             "Content-Type" "application/json; charset=UTF-8",
             "X-Content-Type-Options" "nosniff",
             "Alt-Svc" "h3-29=\":443\"; ma=2592000,h3-T051=\":443\"; ma=2592000,h3-Q050=\":443\"; ma=2592000,h3-Q046=\":443\"; ma=2592000,h3-Q043=\":443\"; ma=2592000,quic=\":443\"; ma=2592000; v=\"46,43\"",
             "X-Frame-Options" "SAMEORIGIN",
             "Connection" "close",
             "Transfer-Encoding" "chunked",
             "Date" "Wed, 16 Dec 2020 15:56:23 GMT",
             "Vary" ["Origin" "X-Origin" "Referer"],
             "X-XSS-Protection" "0",
             "Cache-Control" "private"},
   :orig-content-encoding "gzip",
   :status 200,
   :length -1,
   :body {:kind "youtube#searchListResponse",
          :etag "eQ0xl6vu-eBNbyYQl28yi4REnzg",
          :nextPageToken "CDcQAA",
          :prevPageToken "CDIQAQ",
          :regionCode "US",
          :pageInfo {:totalResults 1000000, :resultsPerPage 5},
          :items [{:kind "youtube#searchResult",
                   :etag "mMVWDyJoXa-QuKJJNV15sLee5bc",
                   :id {:kind "youtube#channel", :channelId "UCr8_w2pAJlGAwu-qz4bYmrw"},
                   :snippet {:publishedAt "2015-03-19T00:58:29Z",
                             :channelId "UCr8_w2pAJlGAwu-qz4bYmrw",
                             :title "Fusion Comedy",
                             :description "Fusion Comedy is comedy that gives an F.",
                             :thumbnails {:default {:url "https://yt3.ggpht.com/ytc/AAUvwnjxpGFM98Ox-fXw-UCWbF-X-Zgq-6rVadnqeFnl=s88-c-k-c0xffffffff-no-rj-mo"},
                                          :medium {:url "https://yt3.ggpht.com/ytc/AAUvwnjxpGFM98Ox-fXw-UCWbF-X-Zgq-6rVadnqeFnl=s240-c-k-c0xffffffff-no-rj-mo"},
                                          :high {:url "https://yt3.ggpht.com/ytc/AAUvwnjxpGFM98Ox-fXw-UCWbF-X-Zgq-6rVadnqeFnl=s800-c-k-c0xffffffff-no-rj-mo"}},
                             :channelTitle "Fusion Comedy",
                             :liveBroadcastContent "upcoming",
                             :publishTime "2015-03-19T00:58:29Z"}}
                  {:kind "youtube#searchResult",
                   :etag "tOfZD14UAf4bvMFZRRsZifF9IV8",
                   :id {:kind "youtube#channel", :channelId "UC8hgtdIe5SdM7VmIAc_TNcw"},
                   :snippet {:publishedAt "2014-04-23T14:15:18Z",
                             :channelId "UC8hgtdIe5SdM7VmIAc_TNcw",
                             :title "Joanna F. Benz",
                             :description "Special Needs Mother and Instagram motoblogger, chasing her dreams on two wheels Website: http://joannafbenz.com Instagram: ...",
                             :thumbnails {:default {:url "https://yt3.ggpht.com/ytc/AAUvwngWqH8ww62Q7NQiSt47sEOTColCVdwyh_iRhvZt=s88-c-k-c0xffffffff-no-rj-mo"},
                                          :medium {:url "https://yt3.ggpht.com/ytc/AAUvwngWqH8ww62Q7NQiSt47sEOTColCVdwyh_iRhvZt=s240-c-k-c0xffffffff-no-rj-mo"},
                                          :high {:url "https://yt3.ggpht.com/ytc/AAUvwngWqH8ww62Q7NQiSt47sEOTColCVdwyh_iRhvZt=s800-c-k-c0xffffffff-no-rj-mo"}},
                             :channelTitle "Joanna F. Benz",
                             :liveBroadcastContent "none",
                             :publishTime "2014-04-23T14:15:18Z"}}
                  {:kind "youtube#searchResult",
                   :etag "eD4YkrMwkVjGgBKpr8mtIPlU3Ns",
                   :id {:kind "youtube#channel", :channelId "UCLpuOt1XyZPbfX6cDHWhtjg"},
                   :snippet {:publishedAt "2011-05-06T02:01:22Z",
                             :channelId "UCLpuOt1XyZPbfX6cDHWhtjg",
                             :title "Exe F",
                             :description "",
                             :thumbnails {:default {:url "https://yt3.ggpht.com/ytc/AAUvwnhkNKp7BPvbf-CBlokH86LV-xvKBHBvkLpumO2hbQ=s88-c-k-c0xffffffff-no-rj-mo"},
                                          :medium {:url "https://yt3.ggpht.com/ytc/AAUvwnhkNKp7BPvbf-CBlokH86LV-xvKBHBvkLpumO2hbQ=s240-c-k-c0xffffffff-no-rj-mo"},
                                          :high {:url "https://yt3.ggpht.com/ytc/AAUvwnhkNKp7BPvbf-CBlokH86LV-xvKBHBvkLpumO2hbQ=s800-c-k-c0xffffffff-no-rj-mo"}},
                             :channelTitle "Exe F",
                             :liveBroadcastContent "none",
                             :publishTime "2011-05-06T02:01:22Z"}}
                  {:kind "youtube#searchResult",
                   :etag "mzQste04SlzSDW-WM1CDbOEYnGE",
                   :id {:kind "youtube#channel", :channelId "UCTuOFaKB505YqA0RuKpTWxQ"},
                   :snippet {:publishedAt "2013-06-23T23:13:15Z",
                             :channelId "UCTuOFaKB505YqA0RuKpTWxQ",
                             :title "let??cia f.",
                             :description "soy luna stuff.",
                             :thumbnails {:default {:url "https://yt3.ggpht.com/ytc/AAUvwnga9ei4MEOWyFy0zf1T1BnHjx-o5GBO3A7wLiuxdw=s88-c-k-c0xffffffff-no-rj-mo"},
                                          :medium {:url "https://yt3.ggpht.com/ytc/AAUvwnga9ei4MEOWyFy0zf1T1BnHjx-o5GBO3A7wLiuxdw=s240-c-k-c0xffffffff-no-rj-mo"},
                                          :high {:url "https://yt3.ggpht.com/ytc/AAUvwnga9ei4MEOWyFy0zf1T1BnHjx-o5GBO3A7wLiuxdw=s800-c-k-c0xffffffff-no-rj-mo"}},
                             :channelTitle "let??cia f.",
                             :liveBroadcastContent "upcoming",
                             :publishTime "2013-06-23T23:13:15Z"}}
                  {:kind "youtube#searchResult",
                   :etag "myp5XQ069hrgrhDCpv31Co8Q6Nc",
                   :id {:kind "youtube#channel", :channelId "UCjNVRNZ2eQ0eCCvwHN6Y1DQ"},
                   :snippet {:publishedAt "2011-06-28T01:02:02Z",
                             :channelId "UCjNVRNZ2eQ0eCCvwHN6Y1DQ",
                             :title "Kai F",
                             :description "Mind is blown* 3.",
                             :thumbnails {:default {:url "https://yt3.ggpht.com/ytc/AAUvwni6eedCH28FvSk3a07DtVfe3zPE8a2WsoPtyMzHvg=s88-c-k-c0xffffffff-no-rj-mo"},
                                          :medium {:url "https://yt3.ggpht.com/ytc/AAUvwni6eedCH28FvSk3a07DtVfe3zPE8a2WsoPtyMzHvg=s240-c-k-c0xffffffff-no-rj-mo"},
                                          :high {:url "https://yt3.ggpht.com/ytc/AAUvwni6eedCH28FvSk3a07DtVfe3zPE8a2WsoPtyMzHvg=s800-c-k-c0xffffffff-no-rj-mo"}},
                             :channelTitle "Kai F",
                             :liveBroadcastContent "none",
                             :publishTime "2011-06-28T01:02:02Z"}}]},
   :trace-redirects []}

  )
(def sample-vid-list-response
  {:cached nil,
   :request-time 382,
   :repeatable? false,
   :protocol-version {:name "HTTP", :major 1, :minor 1},
   :streaming? true,
   :http-client "org.apache.http.impl.client.InternalHttpClient@70c14130"
   :chunked? true,
   :reason-phrase "OK",
   :headers {"Server" "scaffolding on HTTPServer2",
             "Content-Type" "application/json; charset=UTF-8",
             "X-Content-Type-Options" "nosniff",
             "Alt-Svc" "h3-29=\":443\"; ma=2592000,h3-T051=\":443\"; ma=2592000,h3-Q050=\":443\"; ma=2592000,h3-Q046=\":443\"; ma=2592000,h3-Q043=\":443\"; ma=2592000,quic=\":443\"; ma=2592000; v=\"46,43\"",
             "X-Frame-Options" "SAMEORIGIN",
             "Connection" "close",
             "Transfer-Encoding" "chunked",
             "Date" "Fri, 18 Dec 2020 21:01:08 GMT",
             "Vary" ["Origin" "X-Origin" "Referer"],
             "X-XSS-Protection" "0",
             "Cache-Control" "private"},
   :orig-content-encoding "gzip",
   :status 200,
   :length -1,
   :body {:kind "youtube#videoListResponse",
          :etag "uC1iJfSjb6259yn71JGR6kz63oU",
          :items [{:kind "youtube#video",
                   :etag "P2Or1pO81lirJPFO9gJjCvWl_Rk",
                   :id "DHHF2q6Sz94",
                   :snippet {:description "This is not clickbait I am an idiot.
                                         This video was sponsored by WILLIAM OSMAN buy merch at: https://www.catwarehouse.com/ 15% off if you help the cat open the pickle jar.
                                         @Allen Pan - Sufficiently Advanced
                                         Support me on Patreon: https://www.patreon.com/williamosman
                                         Twitter: https://twitter.com/CrabsAndScience",
                             :tags ["laser cutter"
                                    "william osman"
                                    "crappy science"
                                    "peter sripol"
                                    "simone giertz"
                                    "allen pan"
                                    "colin furze"
                                    "thehacksmith"
                                    "michael reeves"],
                             :publishedAt "2020-12-16T13:44:23Z",
                             :channelId "UCfMJ2MchTSW2kWaT0kK94Yw",
                             :categoryId "28",
                             :thumbnails {:default {:url "https://i.ytimg.com/vi/DHHF2q6Sz94/default.jpg",
                                                    :width 120,
                                                    :height 90},
                                          :medium {:url "https://i.ytimg.com/vi/DHHF2q6Sz94/mqdefault.jpg",
                                                   :width 320,
                                                   :height 180},
                                          :high {:url "https://i.ytimg.com/vi/DHHF2q6Sz94/hqdefault.jpg",
                                                 :width 480,
                                                 :height 360},
                                          :standard {:url "https://i.ytimg.com/vi/DHHF2q6Sz94/sddefault.jpg",
                                                     :width 640,
                                                     :height 480},
                                          :maxres {:url "https://i.ytimg.com/vi/DHHF2q6Sz94/maxresdefault.jpg",
                                                   :width 1280,
                                                   :height 720}},
                             :title "I Bought a BattleBot From the TV Show",
                             :defaultAudioLanguage "en",
                             :liveBroadcastContent "none",
                             :localized {:title "I Bought a BattleBot From the TV Show",
                                         :description "This is not clickbait I am an idiot.
                                                     This video was sponsored by WILLIAM OSMAN buy merch at: https://www.catwarehouse.com/ 15% off if you help the cat open the pickle jar.
                                                     @Allen Pan - Sufficiently Advanced
                                                     Support me on Patreon: https://www.patreon.com/williamosman
                                                     Twitter: https://twitter.com/CrabsAndScience"},
                             :channelTitle "William Osman",
                             :defaultLanguage "en"},
                   :contentDetails {:duration "PT10M36S",
                                    :dimension "2d",
                                    :definition "hd",
                                    :caption "false",
                                    :licensedContent true,
                                    :contentRating {},
                                    :projection "rectangular"},
                   :statistics {:viewCount "1033509",
                                :likeCount "76460",
                                :dislikeCount "812",
                                :favoriteCount "0",
                                :commentCount "4030"}}],
          :nextPageToken "CDMQAA",
          :prevPageToken "CDIQAQ",
          :pageInfo {:totalResults 200, :resultsPerPage 1}},
   :trace-redirects []}
  )
(def sample-channel-list-response
  {:cached nil,
   :request-time 368,
   :repeatable? false,
   :protocol-version {:name "HTTP", :major 1, :minor 1},
   :streaming? true,
   :http-client "org.apache.http.impl.client.InternalHttpClient@70c14130",
   :chunked? true,
   :reason-phrase "OK",
   :headers {"Server" "scaffolding on HTTPServer2",
             "Content-Type" "application/json; charset=UTF-8",
             "X-Content-Type-Options" "nosniff",
             "Alt-Svc" "h3-29=\":443\"; ma=2592000,h3-T051=\":443\"; ma=2592000,h3-Q050=\":443\"; ma=2592000,h3-Q046=\":443\"; ma=2592000,h3-Q043=\":443\"; ma=2592000,quic=\":443\"; ma=2592000; v=\"46,43\"",
             "X-Frame-Options" "SAMEORIGIN",
             "Connection" "close",
             "Transfer-Encoding" "chunked",
             "Date" "Tue, 22 Dec 2020 20:45:36 GMT",
             "Vary" ["Origin" "X-Origin" "Referer"],
             "X-XSS-Protection" "0",
             "Cache-Control" "private"},
   :orig-content-encoding "gzip",
   :status 200,
   :length -1,
   :body {:kind "youtube#channelListResponse",
          :etag "fXyWoPb2-0odPqxJ3Yw1DMFTnBM",
          :pageInfo {:totalResults 1, :resultsPerPage 1},
          :items [{:kind "youtube#channel",
                   :etag "yim-B9bjlAr-Jv5xB0MqnGXHIHk",
                   :id "UC_x5XG1OV2P6uZZ5FSM9Ttw",
                   :snippet {:title "Google Developers",
                             :description "The Google Developers channel features talks from events, educational series, best practices, tips, and the latest updates across our products and platforms.",
                             :customUrl "googledevelopers",
                             :publishedAt "2007-08-23T00:34:43Z",
                             :thumbnails {:default {:url "https://yt3.ggpht.com/ytc/AAUvwngOju7AKiAvKEs1wtsZN366tyNPyMq3nD8eFkMF7bE=s88-c-k-c0x00ffffff-no-rj",
                                                    :width 88,
                                                    :height 88},
                                          :medium {:url "https://yt3.ggpht.com/ytc/AAUvwngOju7AKiAvKEs1wtsZN366tyNPyMq3nD8eFkMF7bE=s240-c-k-c0x00ffffff-no-rj",
                                                   :width 240,
                                                   :height 240},
                                          :high {:url "https://yt3.ggpht.com/ytc/AAUvwngOju7AKiAvKEs1wtsZN366tyNPyMq3nD8eFkMF7bE=s800-c-k-c0x00ffffff-no-rj",
                                                 :width 800,
                                                 :height 800}},
                             :localized {:title "Google Developers",
                                         :description "The Google Developers channel features talks from events, educational series, best practices, tips, and the latest updates across our products and platforms."},
                             :country "US"},
                   :contentDetails {:relatedPlaylists {:likes "", :favorites "", :uploads "UU_x5XG1OV2P6uZZ5FSM9Ttw"}},
                   :statistics {:viewCount "178876040",
                                :subscriberCount "2130000",
                                :hiddenSubscriberCount false,
                                :videoCount "5256"}}]},
   :trace-redirects []}
  )

(defn remove-deep [key-set data]
  (clojure.walk/prewalk (fn [node] (if (map? node)
                                     (apply dissoc node key-set)
                                     node))
                        data))

(def sample-search-list-first-response
  (remove-deep [:prevPageToken] sample-search-list-response)
  )

;; (deftest test-video-endpoint
;;   (is (= (keys sample-vid-list-response) (keys (get-most-popular-vids-by-region)) ) "Testing top-level keys equality." )
;;   (is (= (keys (:body sample-vid-list-response) ) (keys (:body (get-most-popular-vids-by-region))) ) "Testing body-level keys equality." )
;;   )

;(deftest test-search-endpoint
;  (is (= (keys sample-search-list-response) (keys (get-most-popular-channels-by-query)) ) "Testing top-level keys equality." )
;  (is (= (keys (:body sample-search-list-response) ) (keys (:body (get-most-popular-channels-by-query))) ) "Testing body-level keys equality." )
;  )

;; (deftest test-channel-endpoint
;;   (is (= (keys sample-channel-list-response) (keys (get-channel-from-channel-id)) ) "Testing top-level keys equality." )
;;   (is (= (keys (:body sample-channel-list-response) ) (keys (:body (get-channel-from-channel-id))) ) "Testing body-level keys equality." )
;;   )
