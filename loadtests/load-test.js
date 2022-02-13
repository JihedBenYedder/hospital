import { sleep } from 'k6';
import http from 'k6/http';

export const options = {
  duration: '1m',
  vus: 50,
  thresholds: {
    http_req_duration: ['p(95)<500'], // 95 percent of response times must be below 500ms
  },
};

export default function () {
  http.get('http://k8s-dev-d86f3a475c-488485548.us-east-2.elb.amazonaws.com/hospital/beds/total');
  sleep(3);
}