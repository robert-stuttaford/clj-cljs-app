.PHONY: all dev test

all: dev

repl:
	clojure -A:cljs:dev clj-repl

dev:
	clojure -A:cljs:dev clj-run build/run

http:
	cd resources/public && python -m SimpleHTTPServer

js-deps:
	rm -rf .node_modules .shadow-cljs && npm install

clean:
	rm -rf .shadow-cljs .cpcache resources/public/cljs target

release-cljs:
	@echo "Build release js"
	clojure -A:cljs release app --config-merge '{:output-dir "target/cljs"}'

debug-cljs:
	@echo "Build release debug js"
	clojure -A:cljs release app --debug --config-merge '{:output-dir "target/cljs"}'