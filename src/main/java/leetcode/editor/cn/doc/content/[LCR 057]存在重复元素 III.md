<p>给你一个整数数组 <code>nums</code> 和两个整数&nbsp;<code>k</code> 和 <code>t</code> 。请你判断是否存在 <b>两个不同下标</b> <code>i</code> 和 <code>j</code>，使得&nbsp;<code>abs(nums[i] - nums[j]) &lt;= t</code> ，同时又满足 <code>abs(i - j) &lt;= k</code><em> </em>。</p>

<p>如果存在则返回 <code>true</code>，不存在返回 <code>false</code>。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,1], k<em> </em>= 3, t = 0
<strong>输出：</strong>true</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,0,1,1], k<em> </em>=<em> </em>1, t = 2
<strong>输出：</strong>true</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,5,9,1,5,9], k = 2, t = 3
<strong>输出：</strong>false</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>0 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li> 
 <li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li> 
 <li><code>0 &lt;= k &lt;= 10<sup>4</sup></code></li> 
 <li><code>0 &lt;= t &lt;= 2<sup>31</sup> - 1</code></li> 
</ul>

<p>&nbsp;</p>

<p>
 <meta charset="UTF-8" />注意：本题与主站 220&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/contains-duplicate-iii/">https://leetcode-cn.com/problems/contains-duplicate-iii/</a></p>

<div><div>Related Topics</div><div><li>数组</li><li>桶排序</li><li>有序集合</li><li>排序</li><li>滑动窗口</li></div></div><br><div><li>👍 95</li><li>👎 0</li></div>