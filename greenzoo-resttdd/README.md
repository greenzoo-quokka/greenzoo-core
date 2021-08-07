# greenzoo-resttdd
* RESTAPI + TDD 프로젝트

* 참고사이트
* 백기선님 강의중

* REST를 구성하는 스타일
> Client - Server
> Stateless
> cache
> uniform interface
> layered system
> code-on-demand(optional)

* Uniform Interface
> 독립적인 진화
> 서버의 기능이 변경되어도 클라이언트를 업데이트할 필요없다.
> ex) 웹 브라우저 - HTTP, HTML 명세가 변경되어도 웹은 잘동작한다.
> Self-descriptive messages
> > 메시지는 스스로 설명해야한다. 
> > 어떤 문법(미디어타입)인지?
> > 각 키는 무슨 뜻인지?(명세)
> > 리턴 메시지로 다 설명이 가능해야함
> hypermedia as the engine of application state(HATEOAS)
> > 애플리케이션의 상태는 Hyperlink를 이용해 전이되어야 한다.

* TDD 작성 후 아래와 같은 형태 테스트
> Self-descriptive messages, HATEOAS 확인
```
{{Media Type}}
{
    "data" : {
​    },
    "_links" : {
        "self" : {
            "href" : "http://localhost~~~"
        },
        "get-account" : {
            "href" : "http://localhost~~~"
        },
        "create-account" : {
            "href" : "http://localhost~~~"
        },
        "update-account" : {
            "href" : "http://localhost~~~"
        },
        "delete-account" : {
            "href" : "http://localhost~~~"
        }
    }
}
```