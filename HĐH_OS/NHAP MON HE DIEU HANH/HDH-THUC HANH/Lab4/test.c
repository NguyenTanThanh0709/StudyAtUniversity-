#include &lt;stdio.h&gt;
#include &lt;stdlib.h&gt;
#include &lt;pthread.h&gt;
#include &lt;sys/time.h&gt;

/* define variables for the problem */
#define SEED 100
#define LENGTH 1000000
#define UPPER_LIM 1000000
#define LOWER_LIM 1
#define NUM_THREADS 2

/* define derived values from the variables */
const int NUMBERS_PER_THREAD = LENGTH / NUM_THREADS;
const int OFFSET = LENGTH % NUM_THREADS;
int arr[LENGTH];

/* function definitions */
int generate_random_number(unsigned int lower_limit, unsigned int upper_limit);
void merge_sort(int arr[], int left, int right);
void merge(int arr[], int left, int middle, int right);
void* thread_merge_sort(void* arg);
void merge_sections_of_array(int arr[], int number, int aggregation);
void test_array_is_in_order(int arr[]);

int main(int argc, const char * argv[]) {
srand(SEED);
struct timeval start, end;
double time_spent;

/* initialize array with random numbers */
int i1;
for (i1 = 0; i1 &lt; LENGTH; i1 ++) {
arr[i1] = generate_random_number(LOWER_LIM, UPPER_LIM);
}
/*for (i1 = 0; i1 &lt; LENGTH; i1 ++) {
printf(&quot;%d &quot;,arr[i1]);}
printf(&quot;\n &quot;);*/
/* begin timing */
pthread_t threads[NUM_THREADS];
gettimeofday(&amp;start, NULL);

/* create threads */
long i;
for (i = 0; i &lt; NUM_THREADS; i ++) {
int rc = pthread_create(&amp;threads[i], NULL, thread_merge_sort, (void *)i);
if (rc){
printf(&quot;ERROR; return code from pthread_create() is %d\n&quot;, rc);
exit(-1);
}
}

for( i = 0; i &lt; NUM_THREADS; i++) {
pthread_join(threads[i], NULL);
}

merge_sections_of_array(arr, NUM_THREADS, 1);
/*for (i1 = 0; i1 &lt; LENGTH; i1 ++) {
printf(&quot;%d &quot;,arr[i1]);}*/

/* end timing */

time_spent = ((double) ((double) (end.tv_usec - start.tv_usec) / 1000000 +
(double) (end.tv_sec - start.tv_sec)));
printf(&quot;Time taken for execution: %f seconds\n&quot;, time_spent);
/* test to ensure that the array is in sorted order */
/* test_array_is_in_order(arr); */
return 0;
}

/* generate random numbers within the specified limit */
int generate_random_number(unsigned int lower_limit, unsigned int upper_limit) {
return lower_limit + (upper_limit - lower_limit) * ((double)rand() / RAND_MAX);
}

/* merge locally sorted sections */

void merge_sections_of_array(int arr[], int number, int aggregation) {
int i;

for(i = 0; i &lt; number; i = i + 2) {
int left = i * (NUMBERS_PER_THREAD * aggregation);
int right = ((i + 2) * NUMBERS_PER_THREAD * aggregation) - 1;
int middle = left + (NUMBERS_PER_THREAD * aggregation) - 1;
if (right &gt;= LENGTH) {
right = LENGTH - 1;
}
merge(arr, left, middle, right);
}
if (number / 2 &gt;= 1) {
merge_sections_of_array(arr, number / 2, aggregation * 2);
}
}

/** assigns work to each thread to perform merge sort */
void *thread_merge_sort(void* arg)
{
int thread_id = (long)arg;
int left = thread_id * (NUMBERS_PER_THREAD);
int right = (thread_id + 1) * (NUMBERS_PER_THREAD) - 1;
if (thread_id == NUM_THREADS - 1) {
right += OFFSET;
}
int middle = left + (right - left) / 2;
if (left &lt; right) {
merge_sort(arr, left, right);
merge_sort(arr, left + 1, right);

merge(arr, left, middle, right);
}
return NULL;
}

/* test to ensure that the array is in sorted order */
void test_array_is_in_order(int arr[]) {
int max = 0,i;
for (i = 1; i &lt; LENGTH; i ++) {
if (arr[i] &gt;= arr[i - 1]) {
max = arr[i];
} else {
printf(&quot;Error. Out of order sequence: %d found\n&quot;, arr[i]);
return;
}
}
printf(&quot;Array is in sorted order\n&quot;);
}

/* perform merge sort */
void merge_sort(int arr[], int left, int right) {
if (left &lt; right) {
int middle = left + (right - left) / 2;
merge_sort(arr, left, middle);
merge_sort(arr, middle + 1, right);
merge(arr, left, middle, right);
}

}

/* merge function */
void merge(int arr[], int left, int middle, int right) {
int i = 0;
int j = 0;
int k = 0;
int left_length = middle - left + 1;
int right_length = right - middle;
int left_array[left_length];
int right_array[right_length];

/* copy values to left array */

for (i = 0; i &lt; left_length; i ++) {
left_array[i] = arr[left + i];
}

/* copy values to right array */
for (j = 0; j &lt; right_length; j ++) {
right_array[j] = arr[middle + 1 + j];
}

i = 0;
j = 0;
/** chose from right and left arrays and copy */
while (i &lt; left_length &amp;&amp; j &lt; right_length) {

if (left_array[i] &lt;= right_array[j]) {
arr[left + k] = left_array[i];
i ++;
} else {
arr[left + k] = right_array[j];
j ++;
}
k ++;
}

/* copy the remaining values to the array */
while (i &lt; left_length) {
arr[left + k] = left_array[i];
k ++;
i ++;
}
while (j &lt; right_length) {
arr[left + k] = right_array[j];
k ++;
j ++;
}
}